package com.xyz.lql.interceptor;

import com.sun.tools.javac.util.StringUtils;
import com.xyz.lql.annotation.RequiredPermission;
import com.xyz.lql.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-2-15 11:47
 */
public class SecurityInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 验证权限
		if (this.hasPermission(request, handler)) {
			return true;
		}
		throw new AppException(-1, "无权限");
	}

	private boolean hasPermission(HttpServletRequest request, Object handler) {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			// 获取方法上的注解
			RequiredPermission requiredPermission = handlerMethod.getMethod().getAnnotation(RequiredPermission.class);
			if (requiredPermission == null) {
				// 获取类上的注解
				requiredPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RequiredPermission.class);
			}
			if (requiredPermission == null) {
				return true;
			}
			if (requiredPermission != null && !"".equals(requiredPermission.value())) {
				String value = requiredPermission.value();
				String userName = request.getHeader("session_id");
				System.out.println(value + "-----------");
				return true;
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
