package org.jdbclearning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Executors;

public class getPerson {
    public static void main(String[] args) throws Exception {
    try {
        Connection connection = ConnectionDb.getConnection();
        String qr = "select * from person where id = ?";
        PreparedStatement statement = connection.prepareStatement(qr);

        statement.setInt(1,1);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            String n = resultSet.getString("name");
            String c = resultSet.getString("city");
            System.out.println("name : "+n + " city: " +c );
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
}
