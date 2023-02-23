package cn.thefronts.oss.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chenkun
 * @date 2023/2/22
 */
@Setter
@Getter
public class ObjectInfo {
    /**
     * 对象查看路径
     */
    private String objectUrl;
    /**
     * 对象保存路径
     */
    private String objectPath;
}
