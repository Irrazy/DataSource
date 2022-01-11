import Impl.dbcpDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: dbcp-demo2
 * @description: test
 * @author: 作者
 * @create: 2021-12-28 10:37
 */
public class DBCPtest1 {

    @Test
    public void testInsert() {
        String sql="insert into book(bid,bname,bcount,bauthor) values (6,'基础算法',15,'Richou')";
        //获取配置了数据源信息xml的应用上下文容器
        ApplicationContext context=new ClassPathXmlApplicationContext("dbcpDataSource.xml");
        //从容器中拿到实例化的执行dao操作的bean对象
        dbcpDAOImpl dbcpDaoImpl=(dbcpDAOImpl)context.getBean("dbcpDAOImpl");
        //实例化对象调用相应方法
        dbcpDaoImpl.insert1(sql);



    }
}
