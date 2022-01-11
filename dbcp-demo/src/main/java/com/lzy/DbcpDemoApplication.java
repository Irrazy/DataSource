package com.lzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DbcpDemoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DbcpDemoApplication.class, args);
    }

}
