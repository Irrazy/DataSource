import Impl.c3p0DaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: c3p0-demo
 * @description: test
 * @author: 作者
 * @create: 2021-12-28 16:03
 */
public class c3p0Test {
    @Test
    public void testInsert() {
        String sql="insert into book(bid,bname,bcount,bauthor) values (7,'React',12,'Luise')";
        //获取配置了数据源信息xml的应用上下文容器
        ApplicationContext context=new ClassPathXmlApplicationContext("c3p0DataSource.xml");
        //从容器中拿到实例化的执行dao操作的bean对象
        c3p0DaoImpl c3p0daoImpl=(c3p0DaoImpl)context.getBean("c3p0Impl");
        //实例化对象调用相应方法
        c3p0daoImpl.insert1(sql);



    }
}
