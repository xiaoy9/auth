package com.xiao9.infrastruction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class Swagger3Config {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiao9.facade.rest"))
                .paths(PathSelectors.ant("/api/**"))
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户服务")
                .description("用户相关的登录已经权限认证等功能")
                .version("1.0")
                .build();
    }

}
