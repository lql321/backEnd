package com.xyz.lql.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-1-30 16:40
 */
@EnableSwagger2
@Configuration
@Profile({"dev","test"})
public class Swagger2 {

	private List<Parameter> getHeader() {
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		tokenPar.name("session_id").description("密钥").modelRef(new ModelRef("string")).parameterType("header").required(false);
		pars.add(tokenPar.build());
		return pars;
	}

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/index/**")).build().groupName("默认API").pathMapping("/")
				.apiInfo(apiInfo("主界面", "文档中可以查询及测试接口调用参数和结果", "1.0")).globalOperationParameters(getHeader());
	}

	private ApiInfo apiInfo(String name, String description, String version) {
		ApiInfo apiInfo = new ApiInfoBuilder().title(name).description(description).version(version).build();
		return apiInfo;
	}

}
