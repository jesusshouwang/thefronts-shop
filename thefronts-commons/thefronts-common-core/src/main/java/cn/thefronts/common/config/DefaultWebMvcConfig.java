package cn.thefronts.common.config;

import cn.thefronts.common.feign.UserService;
import cn.thefronts.common.resolver.ClientArgumentResolver;
import cn.thefronts.common.resolver.TokenArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 默认SpringMVC拦截器
 *
 * @author chenkun
 * @date 2023/2/22 16:44
 */
public class DefaultWebMvcConfig implements WebMvcConfigurer {
	@Lazy
	@Autowired
	private UserService userService;

	/**
	 * Token参数解析
	 *
	 * @param argumentResolvers 解析类
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		//注入用户信息
		argumentResolvers.add(new TokenArgumentResolver(userService));
		//注入应用信息
		argumentResolvers.add(new ClientArgumentResolver());
	}
}
