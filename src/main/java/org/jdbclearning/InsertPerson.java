package org.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertPerson {
    public static void main(String[] args) throws Exception {
        int id = 7;
        String name = "ad";
        String city = "pune";

        try {
//            Connection connection  = ConnectionDb.getConnection();
//            PreparedStatement statement = connection.prepareStatement("insert into person values(?,?,?)");
//            statement.setInt(1,id);
//            statement.setString(2,name);
//            statement.setString(3,city);
//
//            ResultSet resultSet = statement.executeQuery();

            UtilityJdbc.executeSqlDml("insert into person values(?,?,?)",id,name,city);

        }catch (Exception e){

        }

    }
}
