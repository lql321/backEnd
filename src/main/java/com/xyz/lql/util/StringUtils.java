package com.xyz.lql.util;

import java.util.UUID;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-10-14 22:14
 */
public class StringUtils {
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();   //转化为String对象
		return uuid.replace("-", ""); //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
	}
}
