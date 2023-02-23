package cn.thefronts.oauth.service.impl;

import cn.thefronts.common.redis.template.RedisRepository;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * JdbcAuthorizationCodeServices替换
 *
 * @author thefronts
 * @date 2023/2/22
 */
@Service
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {
    private final RedisRepository redisRepository;
    private final RedisSerializer<Object> valueSerializer;

    public RedisAuthorizationCodeServices(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
        this.valueSerializer = RedisSerializer.java();
    }

    /**
     * 替换JdbcAuthorizationCodeServices的存储策略
     * 将存储code到redis，并设置过期时间，10分钟
     */
    @Override
    protected void store(String code, OAuth2Authentication authentication) {
        redisRepository.setExpire(redisKey(code), authentication, 10, TimeUnit.MINUTES, valueSerializer);
    }

    @Override
    protected OAuth2Authentication remove(final String code) {
        String codeKey = redisKey(code);
        OAuth2Authentication token = (OAuth2Authentication) redisRepository.get(codeKey, valueSerializer);
        redisRepository.del(codeKey);
        return token;
    }

    /**
     * redis中 code key的前缀
     *
     * @param code
     * @return
     */
    private String redisKey(String code) {
        return "oauth:code:" + code;
    }
}
