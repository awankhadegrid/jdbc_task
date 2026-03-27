package org.jdbclearning;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/jdbclearn";
        String user = "postgres";
        String pass = "abhi";

        try(
                Connection connection = DriverManager.getConnection(url,user,pass);
                Connection connection1 = DriverManager.getConnection(url,user,pass);
                PreparedStatement st = connection.prepareStatement("select * from person where id = ?");
                PreparedStatement st1 = connection1.prepareStatement("select * from person where id = ?");
        ){
            st.setInt(1,2);
            st1.setInt(1,3);
            ResultSet resultSet = st.executeQuery();
            ResultSet resultSet1 = st1.executeQuery();

            while(resultSet1.next()){
                String c = resultSet1.getString("name");
                String d = resultSet1.getString("city");
                System.out.println("name  "+c+" city "+d);
            }
            while(resultSet.next()){
                String a = resultSet.getString("name");
                String b = resultSet.getString("city");
                System.out.println("name  "+a+" city "+b);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
