package org.jdbclearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityJdbc {

    // return result set

    public static ResultSet executeSql(String qr,Object... arg) throws SQLException {

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(qr))
            {
            for (int i=0;i<arg.length;i++){
                statement.setObject(i+1,arg[i]);
            }

            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // does not return anything and use for DML

    public static void executeSqlDml(String qr,Object... arg) throws SQLException{
        try (
                Connection connection = ConnectionDb.getConnection();
                PreparedStatement statement = connection.prepareStatement(qr))
        {
            for (int i=0;i<arg.length;i++){
                statement.setObject(i+1,arg[i]);
            }

            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
