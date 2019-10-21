package com.xyz.lql.config;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 切面日志响应类
 *
 * @author lql
 * @Description: TODO
 * @date 2019-1-28 17:45
 */
@Aspect
@Component
public class WebLogAspect {
	private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
	ThreadLocal<Long> startTime = new ThreadLocal<>();

	//使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等
	@Pointcut("execution(public * com.xyz.lql.controller.*.*.*(..))")
	public void webLog() {
	}

	/**
	 * 请求之前执行
	 *
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录请求内容
		logger.info("请求URL------	: " + request.getRequestURL().toString());
		logger.info("请求类型-----	: " + request.getMethod());
		logger.info("请求IP-------: " + request.getRemoteAddr());
		logger.info("请求的方法---	: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			if (arg == null || arg instanceof HttpServletRequest || arg instanceof HttpServletResponse) {
				continue;
			}
			try {
				// 防止上传图片时会打印图片的base64码
				if (JSON.toJSONString(arg).length() > 500) {
					logger.info("请求参数为:-----------------------请求参数过长，有可能是上传图片或视屏——————————————");
				} else {
					logger.info("请求参数-----	: " + JSON.toJSONString(arg));
				}
			} catch (Exception e) {
				continue;
			}
		}
	}

	@After("webLog()")
	public void doAfter() {
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("响应数据-----	:" + JSON.toJSONString(ret));
		logger.info("处理时间-----	: " + (System.currentTimeMillis() - startTime.get()) + "ms");
	}
}
