package com.xyz.lql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("com.xyz.lql.dao")
public class LqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(LqlApplication.class, args);
	}

}

