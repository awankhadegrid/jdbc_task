package org.jdbclearning.ConnectionPolling;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Executors;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionMk {
    public static void main(String[] args) throws Exception {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/jdbclearn");
        config.setUsername("postgres");
        config.setPassword("abhi");

        config.setMaximumPoolSize(10);

        HikariDataSource ds = new HikariDataSource(config);

        Connection conn = ds.getConnection();
        PreparedStatement statement = conn.prepareStatement("select * from person");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            int a= resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id : "+ a +" name : "+ name);
        }

        System.out.println("Connected using HikariCP");
        conn.close();

        ds.close();
    }
}
