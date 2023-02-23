package cn.thefronts.common.filter;

import cn.thefronts.common.context.LoginUserContextHolder;
import cn.thefronts.common.model.SysUser;
import cn.thefronts.common.utils.LoginUserUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取当前登录人过滤器
 *
 * @author chenkun
 * @date 2023/2/22
 */
@ConditionalOnClass(Filter.class)
@Order
public class LoginUserFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        try {
            SysUser user = LoginUserUtils.getCurrentUser(request, false);
            LoginUserContextHolder.setUser(user);
            filterChain.doFilter(request, response);
        } finally {
            LoginUserContextHolder.clear();
        }
    }
}
