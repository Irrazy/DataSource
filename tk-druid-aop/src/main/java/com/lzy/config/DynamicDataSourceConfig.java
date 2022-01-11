package com.lzy.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: tk-druid-aop
 * @description: 动态数据源配置类
 * @author: 作者
 * @create: 2022-01-07 11:44
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DynamicDataSourceConfig {
    private final dbsConfig dbsconfig;

 /**   public DynamicDataSourceConfig(dbsConfig dbsconfig) {
        this.dbsconfig = dbsconfig;
    }
  **定义类为静态对象，需构建带参构造函数：1.手写  2.注解@RequiredArgsConstructor    两种方式构建都可以
  **/

    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(){
        Map<Object,Object> dataSourceMap = new HashMap<>();
        //这里的逻辑是有两个map
        //一个是在dbsConfig类中新建的与yml相对应的，存储多个数据源信息，key值为数据源名称，value值为druid数据源类型。
        //一个是刚创建的dataSourceMap存储的是具体的数据源，动态获取数据源就要用到这个map参数。
        //dbsconfig.getDbs()是拿到dbs的map,然后遍历向dataSourceMap中输入dbs里具体的数据源
        dbsconfig.getDbs().forEach(dataSourceMap::put);

        DynamicDataSource dynamicDataSource=new DynamicDataSource();
        /*
          datasource额里面有两个属性targetdatasources 和 defaultTargetDataSource.
          配置好了就可以通过AbstractRoutingDataSource的determineCurrentLookupKey()传入的key来控制用那个数据源.
         */
        //将数据源map传入dynamicDataSource
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        //设置默认数据源----数据库1
        dynamicDataSource.setDefaultTargetDataSource( dbsconfig.getDbs().get("db1"));

        return dynamicDataSource;
    }
}
