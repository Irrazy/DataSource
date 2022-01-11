package com.lzy.datasource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @program: JDBC-DriverManager
 * @description: DriverManageDAO
 * @author: 作者
 * @create: 2021-12-27 13:56
 */
public class DriverManageDAO {
    //在xml文件中配置过的数据源对象
    private DataSource dataSource;
    //用JdbcTemplate模板操作dao
    private JdbcTemplate jdbcTemplate;

    //通过setter依赖注入的方式将配置过的数据源对象注入到操作模板中
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource=dataSource;
        jdbcTemplate=new JdbcTemplate(dataSource);
    }

    //具体sql语句操作方法
    public void insert1(){
        String sql="insert into book(bid,bname,bcount,bauthor) values (5,'数据结构',10,'陈越')";
        jdbcTemplate.update(sql);
    }

}
