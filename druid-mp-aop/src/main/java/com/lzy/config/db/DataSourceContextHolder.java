package com.lzy.config.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: druid-mp-aop
 * @description: 设置、获取数据源
 * @author: 作者
 * @create: 2022-01-06 16:19
 */
public class DataSourceContextHolder {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal contextHolder = new ThreadLocal<>(); //实际上就是开启多个线程，每个线程进行初始化一个数据源
    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setDbType(DBTypeEnum dbTypeEnum) {
        contextHolder.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDbType() {
        return (String) contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType() {
        contextHolder.remove();
    }
}
