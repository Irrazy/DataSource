package com.lzy;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: dbcp-demo
 * @description: DataSourceUtil
 * @author: 作者
 * @create: 2021-12-27 18:01
 */
//通过工具类去读取连接池的配置信息，即application.properties
public class DataSourceUtil {
    private static DataSource source=null;
    //静态代码块的特点吗？随着类的加载而执行，而且只执行一次
    //静态代码块中的代码只执行一次，不需要每次调用这个变量都给它赋值。
    //静态代码块：执行优先级高于非静态的初始化块，它会在类初始化的时候执行一次，执行完成便销毁，它仅能初始化类变量，即static修饰的数据成员。
    static {
        try {
            Properties pros = new Properties();
            InputStream is = DataSource.class.getClassLoader().getResourceAsStream("application.properties");
            pros.load(is);
            //根据BasicDataSourceFactory创建载入了配置信息的dbcp数据源
            source=BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnetion() throws SQLException {
        Connection conn=source.getConnection();
        return conn;
    }


}
