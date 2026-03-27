package org.jdbclearning;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class getAllPerson {
    public static List<User> getallperson() throws SQLException {

        List<User> userList =new ArrayList<>();
       try {
           Connection connection = ConnectionDb.getConnection();
           PreparedStatement statement = connection.prepareStatement("select * from person");
           ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()){
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               String city = resultSet.getString("city");

              User user = new User(id,name,city);

              userList.add(user);
           }

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return userList;
    }


    public static void main(String[] args) throws SQLException {
        List<User> users = getallperson();

        for (User user : users) {
            System.out.println(user.getId() +" " + user.getName()+" "+user.getCity());
        }
    }
}
