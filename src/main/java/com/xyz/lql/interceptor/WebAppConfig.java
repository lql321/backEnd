package com.xyz.lql.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author lql
 * @Description: 注册拦截器类
 * @date 2019-2-12 16:34
 */
@Component
public class WebAppConfig extends WebMvcConfigurationSupport {

	@Value("${swagger.show}")
	private boolean swaggerShow;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new FileUploadInterceptor()).addPathPatterns("/index/**");
		registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/index/**");
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (swaggerShow) {
			registry.addResourceHandler("swagger-ui.html")
					.addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}
}
