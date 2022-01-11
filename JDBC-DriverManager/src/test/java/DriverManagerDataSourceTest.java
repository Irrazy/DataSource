import com.lzy.datasource.DriverManageDAO;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: JDBC-DriverManager
 * @description: test
 * @author: 作者
 * @create: 2021-12-27 14:09
 */
public class DriverManagerDataSourceTest {

    @Test
    public void testDriverManageDAO(){
        //根据DriverManagerDataSource.xml配置文件创建应用上下文
        ApplicationContext context=new ClassPathXmlApplicationContext("DriverManagerDataSource.xml");
        //从上下文容器中获取DriverManageDAO 这个bean对象
        DriverManageDAO driverManageDAO=(DriverManageDAO)context.getBean("DriverManageDAO");
        //调用具体sql方法
        driverManageDAO.insert1();
    }

}
