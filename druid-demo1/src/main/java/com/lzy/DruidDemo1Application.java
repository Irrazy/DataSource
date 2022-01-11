package com.lzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//因为项目使用的是Spring Boot 框架，该框架会自动配置数据源，
// 自动从yml中读取数据源信息，因此我们在配置自定义的数据源的时候，
// 需要exclude = DataSourceAutoConfiguration.class来禁掉数据源的自动配置


@MapperScan("com.lzy.mapper.BookMapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DruidDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(DruidDemo1Application.class, args);
    }

}
