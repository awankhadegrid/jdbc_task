package org.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    public static Connection getConnection() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/jdbclearn";
        String user = "postgres";
        String pass = "abhi";
        return DriverManager.getConnection(url,user,pass);
    }

}
