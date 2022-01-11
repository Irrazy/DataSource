package com.lzy.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @program: tk-druid-aop
 * @description: yml对应中的dbs多项数据源配置
 * @author: 作者
 * @create: 2022-01-07 11:40
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class dbsConfig {
    //key值为yml中的db1,db2
    private Map<String, DruidDataSource> dbs;
}
