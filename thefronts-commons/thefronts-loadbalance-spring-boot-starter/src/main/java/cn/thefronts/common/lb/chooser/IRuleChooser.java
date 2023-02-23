package cn.thefronts.common.lb.chooser;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * service选择器类
 *
 * @author chenkun
 * @date 2023/2/22
 */
public interface IRuleChooser {
    ServiceInstance choose(List<ServiceInstance> instances);
}
