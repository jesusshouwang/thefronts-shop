package cn.thefronts.gateway.feign.fallback;

import cn.hutool.core.collection.CollectionUtil;
import cn.thefronts.gateway.feign.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * menuService降级工场
 *
 * @author chenkun
 * @date 2023/2/2
 */
@Slf4j
@Component
public class MenuServiceFallbackFactory implements FallbackFactory<MenuService> {
    @Override
    public MenuService create(Throwable throwable) {
        return roleIds -> {
            log.error("调用findByRoleCodes异常：{}", roleIds, throwable);
            return CollectionUtil.newArrayList();
        };
    }
}
