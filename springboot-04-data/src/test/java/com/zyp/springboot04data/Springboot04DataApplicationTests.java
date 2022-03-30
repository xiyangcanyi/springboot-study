package com.zyp.springboot04data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        //查看一下默认数据源  class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());
        //获得数据库连接HikariProxyConnection
        // @1041611526 wrapping com.mysql.cj.jdbc.ConnectionImpl@6778aea6 拿来即可使用CRUD（增修改删）
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭
        connection.close();

    }

}
