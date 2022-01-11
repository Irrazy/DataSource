package com.lzy.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: druid-demo1
 * @description: MyBatiesPlusConfiguration
 * @author: 作者
 * @create: 2021-12-31 16:30
 */


@Configuration
@MapperScan("com.lzy.mapper")
public class MyBatiesPlusConfiguration {
    /*
     *1. 分页插件
     * 自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    //分页查询方法2配置，更简便
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 添加分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.POSTGRE_SQL));
        return interceptor;
    }







}
