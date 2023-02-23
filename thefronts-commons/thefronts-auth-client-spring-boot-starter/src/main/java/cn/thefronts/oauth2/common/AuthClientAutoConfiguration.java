package cn.thefronts.oauth2.common;

import cn.thefronts.oauth2.common.properties.SecurityProperties;
import cn.thefronts.oauth2.common.properties.TokenStoreProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * 鉴权自动配置
 *
 * @author chenkun
 * @version 1.0
 * @date 2022/5/8
 */
@EnableConfigurationProperties({SecurityProperties.class, TokenStoreProperties.class})
@ComponentScan
public class AuthClientAutoConfiguration {
}
