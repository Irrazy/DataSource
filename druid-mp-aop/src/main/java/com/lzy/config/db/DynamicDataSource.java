package com.lzy.config.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program: druid-mp-aop
 * @description: 动态数据源决策
 * @author: 作者
 * @create: 2022-01-06 16:17
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String datasource = DataSourceContextHolder.getDbType();
        LOGGER.debug("使用数据源 {}", datasource);
        return datasource;
    }
}
