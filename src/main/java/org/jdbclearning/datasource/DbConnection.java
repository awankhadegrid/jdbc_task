package org.jdbclearning.datasource;

import org.jdbclearning.ConnectionDb;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DbConnection {

    public static void main(String[] args) throws Exception {

        try {

            PGSimpleDataSource dataSource = new PGSimpleDataSource();
            dataSource.setUrl("jdbc:postgresql://localhost:5432/jdbclearn");
            dataSource.setUser("postgres");
            dataSource.setPassword("abhi");

            Connection connection = dataSource.getConnection();
            String qr = "insert into person values(?,?,?)";

            PreparedStatement statement = connection.prepareStatement(qr);

            statement.setInt(1, 6);
            statement.setString(2, "radha");
            statement.setString(3, "mumbai");

            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
