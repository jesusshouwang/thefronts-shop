package cn.thefronts.common.lb.chooser;

import com.alibaba.nacos.common.utils.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机的选择器
 *
 * @author chenkun
 * @date 2023/2/22
 */
@Slf4j
public class RandomRuleChooser implements IRuleChooser {
    @Override
    public ServiceInstance choose(List<ServiceInstance> instances) {
        if (CollectionUtils.isNotEmpty(instances)) {
            int randomValue = ThreadLocalRandom.current().nextInt(instances.size());
            ServiceInstance serviceInstance = instances.get(randomValue);
            log.info("选择了ip为{}, 端口为：{}的服务", serviceInstance.getHost(), serviceInstance.getPort());
            return serviceInstance;
        }
        return null;
    }
}
