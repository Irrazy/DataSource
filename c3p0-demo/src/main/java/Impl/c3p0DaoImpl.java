package Impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import dao.c3p0Dao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;

/**
 * @program: c3p0-demo
 * @description: 实现类
 * @author: 作者
 * @create: 2021-12-28 16:03
 */
public class c3p0DaoImpl implements c3p0Dao {
    //spring提供的三种模板中一般使用SimpleJdbcTemplate，提供自动装箱功能
    //注入对象SimpleJdbcTemplate
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private DataSource C3P0;
    public void setC3p0(ComboPooledDataSource c3p0) {
        this.C3P0=c3p0;
        //通过setter依赖注入的方式将配置过的数据源对象注入到操作模板中
        simpleJdbcTemplate=new SimpleJdbcTemplate(c3p0);
    }


    @Override
    public void insert1(String sql) {
        simpleJdbcTemplate.update(sql);
    }


}
