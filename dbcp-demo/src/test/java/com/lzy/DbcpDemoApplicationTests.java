package com.lzy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootTest
class DbcpDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() throws SQLException {
        Connection conn=null;
        PreparedStatement sta=null;
        try{
            String sql = "insert into book(bid,bname,bcount,bauthor) values (6,'基础算法',15,'Richou')";
            conn=DataSourceUtil.getConnetion();
            sta=conn.prepareStatement(sql);
            sta.execute();
            sta.close();
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            if(sta!=null){
                sta.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
    }

}
