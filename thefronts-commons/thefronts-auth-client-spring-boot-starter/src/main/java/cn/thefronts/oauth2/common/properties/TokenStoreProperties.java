package cn.thefronts.oauth2.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Token配置
 *
 * @author chenkun
 * @version 1.0
 * @date 2022/5/8
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "thefronts.oauth2.token.store")
@RefreshScope
public class TokenStoreProperties {
    /**
     * token存储类型(redis/db/authJwt/resJwt)
     */
    private String type = "redis";
}
