package com.xyz.lql.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lql
 * @Description: 读取配置文件properties
 * @date 2019-1-29 17:07
 */
public class ConfigUtil {
	private static Properties properties;

	public static void loadProperties(String propertiesLocation) {
		properties = new Properties();
		InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(
				propertiesLocation);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取String类型数据
	 *
	 * @param key key
	 * @return value
	 */
	public static String getStringValue(String key) {
		try {
			return properties.getProperty(key).trim();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 获取Integer类型数据
	 *
	 * @param key key
	 * @return value
	 */
	public static Integer getIntegerValue(String key) {
		String value = ConfigUtil.getStringValue(key);
		if (null == value || value.length() == 0) {
			return null;
		}
		return Integer.parseInt(value);
	}

}
