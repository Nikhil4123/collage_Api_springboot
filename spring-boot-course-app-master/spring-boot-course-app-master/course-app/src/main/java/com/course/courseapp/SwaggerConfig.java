package com.course.courseapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @SuppressWarnings("deprecation")
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(new ApiInfo("Course App", "University, student and courses application "
        				+ ", Where you will get all University and Courses related info"
        				+ "", "0.0.1", null, "Mayur Kale", "", ""))
                .select().apis(RequestHandlerSelectors.basePackage("com.course.courseapp.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
