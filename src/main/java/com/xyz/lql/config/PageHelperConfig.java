package com.xyz.lql.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-2-20 17:51
 */
@Configuration
public class PageHelperConfig {
	@Bean
	public PageHelper pageHelper() {
		System.out.println("MyBatisConfiguration.pageHelper()");
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("dialect", "mysql");
		p.setProperty("offsetAsPageNum", "false");
		p.setProperty("rowBoundsWithCount", "false");
		p.setProperty("pageSizeZero", "false");
		p.setProperty("reasonable", "false");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}
