package org.jdbclearning;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeletePerson {
    public static void  deletePerson() throws Exception{

        try {
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement("Delete from person where id = ?");

            statement.setInt(1,4);
            int i=statement.executeUpdate();
            System.out.println(i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("done");
    }

    public static void main(String[] args) throws Exception {
        deletePerson();
    }
}
