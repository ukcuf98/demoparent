package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2019/1/30 14:47
 */
@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Demo Title")
				.description("Demo Description")
				.termsOfServiceUrl("Demo terms of service")
				.version("1.0.0")
				.build();
	}
}
