package Impl;

import dao.dbcpDAO;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;

/**
 * @program: dbcp-demo2
 * @description: DAO实现类
 * @author: 作者
 * @create: 2021-12-28 11:41
 */
public class dbcpDAOImpl implements dbcpDAO {
    //spring提供的三种模板中一般使用SimpleJdbcTemplate，提供自动装箱功能
    //注入对象SimpleJdbcTemplate
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private DataSource dataSource;

    //一定要写被注入对象的set方法才能注入成功
    //通过setter依赖注入的方式将配置过的数据源对象注入到操作模板中
    public void setDataSource(BasicDataSource dataSource){
        this.dataSource=dataSource;
        simpleJdbcTemplate=new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void insert1(String sql) {
        simpleJdbcTemplate.update(sql);
    }

    @Override
    public void findAll() {

    }
}
