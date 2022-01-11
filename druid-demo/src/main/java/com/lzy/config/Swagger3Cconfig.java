package com.lzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: druid-demo
 * @description: swagger文档接口
 * @author: 作者
 * @create: 2021-12-31 10:04
 */
@Configuration
@EnableOpenApi
public class Swagger3Cconfig {
    @Bean
    public Docket createRestApi() {
        // 配置OAS 3.0协议
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class))
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) ----controller接口上的注解是@Operation(summary = "API--获取所有图书信息")
                .apis(RequestHandlerSelectors.basePackage("com.lzy.controller"))// 或者指定包路径--包路径！不是类路径！
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("Irrazy的文档")
                .contact(new Contact("Irrazy", "http://localhost:8989/swagger-ui/index.html", "m13886213612@@163.com"))
                .version("2.0.0")
                .build();
    }


}
