package org.jdbclearning.ConnectionPolling;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

class DBTask implements Runnable {

    private final DataSource ds;

    public DBTask(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT pg_sleep(2)")) {

            stmt.execute();
            System.out.println(Thread.currentThread().getName() + " finished");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}