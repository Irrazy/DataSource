package com.lzy.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: druid-demo1
 * @description: spySQL性能分析插件
 * @author: 作者
 * @create: 2022-01-04 11:02
 */
public class SpySqlFormatConfigure implements MessageFormattingStrategy {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * <p>输出执行sql信息</p >
     * @author
     * @date 2021/12/3
     * @param connectionId
     * @param now 执行时间
     * @param elapsed 耗时多少毫秒
     * @param category
     * @param prepared 准备执行的sql脚本
     * @param sql 执行的sql脚本
     * @param url 数据源连接地址
     */
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String s4) {
        return !"".equals(sql.trim()) ? this.dateFormat.format(new Date()) + " | took " + elapsed + "ms | " + category + " | connection " + connectionId + "\n " + sql + ";" : "";
    }
}
