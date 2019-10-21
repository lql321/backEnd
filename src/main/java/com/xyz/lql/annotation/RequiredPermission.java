package com.xyz.lql.annotation;

import java.lang.annotation.*;

/**
 * @author lql
 * @Description: 权限校验
 * @date 2019-2-15 11:41
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequiredPermission {
	String value();
}
