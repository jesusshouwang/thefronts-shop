package cn.thefronts.oss.config;

import cn.thefronts.oss.properties.FileServerProperties;
import cn.thefronts.oss.template.FdfsTemplate;
import cn.thefronts.oss.template.S3Template;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * @author chenkun
 * @date 2023/2/22

 */
@EnableConfigurationProperties(FileServerProperties.class)
@Import({FdfsTemplate.class, S3Template.class})
public class OssAutoConfigure {

}
