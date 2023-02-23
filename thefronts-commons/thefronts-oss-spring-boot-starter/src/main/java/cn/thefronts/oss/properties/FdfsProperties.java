package cn.thefronts.oss.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * fastdfs配置
 *
 * @author chenkun
 * @date 2023/2/22
 */
@Setter
@Getter
public class FdfsProperties {
    /**
     * fastdfs的http访问地址
     */
    private String webUrl;
}
