package cn.thefronts.common.zookeeper;

import cn.thefronts.common.zookeeper.properties.ZookeeperProperty;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * zookeeper 配置类
 *
 * @author chenkun
 * @version 1.0
 * @date 2022/2/22
 */
@EnableConfigurationProperties(ZookeeperProperty.class)
@ComponentScan
public class ZookeeperAutoConfiguration {
    /**
     * 初始化连接
     */
    @Bean(initMethod = "start", destroyMethod = "close")
    @ConditionalOnMissingBean
    public CuratorFramework curatorFramework(ZookeeperProperty property) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(property.getBaseSleepTime(), property.getMaxRetries());
        return CuratorFrameworkFactory.builder()
                .connectString(property.getConnectString())
                .connectionTimeoutMs(property.getConnectionTimeout())
                .sessionTimeoutMs(property.getSessionTimeout())
                .retryPolicy(retryPolicy)
                .build();
    }
}
