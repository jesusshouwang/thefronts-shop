package cn.thefronts.common.constant;

/**
 * 配置项常量
 *
 * @author chenkun
 * @date 2023/2/22 16:44
 */
public interface ConfigConstants {
    /**
     * 是否开启自定义隔离规则
     */
    String CONFIG_RIBBON_ISOLATION_ENABLED = "thefronts.ribbon.isolation.enabled";

    String CONFIG_LOADBALANCE_ISOLATION = "thefronts.loadbalance.isolation";

    String CONFIG_LOADBALANCE_ISOLATION_ENABLE = CONFIG_LOADBALANCE_ISOLATION + ".enabled";

    String CONFIG_LOADBALANCE_ISOLATION_CHOOSER = CONFIG_LOADBALANCE_ISOLATION + ".chooser";

    String CONFIG_LOADBALANCE_VERSION = "thefronts.loadbalance.version";


}
