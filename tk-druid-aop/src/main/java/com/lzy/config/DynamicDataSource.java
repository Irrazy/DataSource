package com.lzy.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program: tk-druid-aop
 * @description: 动态数据源获取类（不同key值）
 * @author: 作者
 * @create: 2022-01-07 11:48
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }
}
