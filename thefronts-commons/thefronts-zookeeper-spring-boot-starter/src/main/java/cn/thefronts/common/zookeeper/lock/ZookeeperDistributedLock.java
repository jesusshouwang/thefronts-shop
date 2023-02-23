package cn.thefronts.common.zookeeper.lock;

import cn.thefronts.common.constant.CommonConstant;
import cn.thefronts.common.exception.LockException;
import cn.thefronts.common.lock.DistributedLock;
import cn.thefronts.common.lock.ZLock;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * zookeeper分布式锁实现
 *
 * @author chenkun
 * @version 1.0
 * @date 2022/2/22

 */
@Component
@ConditionalOnProperty(prefix = "thefronts.lock", name = "lockerType", havingValue = "ZK")
public class ZookeeperDistributedLock implements DistributedLock {
    @Resource
    private CuratorFramework client;

    private ZLock getLock(String key) {
        InterProcessMutex lock = new InterProcessMutex(client, getPath(key));
        return new ZLock(lock, this);
    }

    @Override
    public ZLock lock(String key, long leaseTime, TimeUnit unit, boolean isFair) throws Exception {
        ZLock zLock = this.getLock(key);
        InterProcessMutex ipm = (InterProcessMutex)zLock.getLock();
        ipm.acquire();
        return zLock;
    }

    @Override
    public ZLock tryLock(String key, long waitTime, long leaseTime, TimeUnit unit, boolean isFair) throws Exception {
        ZLock zLock = this.getLock(key);
        InterProcessMutex ipm = (InterProcessMutex)zLock.getLock();
        if (ipm.acquire(waitTime, unit)) {
            return zLock;
        }
        return null;
    }

    @Override
    public void unlock(Object lock) throws Exception {
        if (lock != null) {
            if (lock instanceof InterProcessMutex) {
                InterProcessMutex ipm = (InterProcessMutex)lock;
                if (ipm.isAcquiredInThisProcess()) {
                    ipm.release();
                }
            } else {
                throw new LockException("requires InterProcessMutex type");
            }
        }
    }

    private String getPath(String key) {
        return CommonConstant.PATH_SPLIT + CommonConstant.LOCK_KEY_PREFIX + CommonConstant.PATH_SPLIT + key;
    }
}
