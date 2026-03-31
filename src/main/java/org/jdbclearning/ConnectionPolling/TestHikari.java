package org.jdbclearning.ConnectionPolling;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class TestHikari {

    public static void main(String[] args) throws Exception {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/jdbclearn");
        config.setUsername("postgres");
        config.setPassword("abhi");

        config.setMaximumPoolSize(5);

        HikariDataSource ds = new HikariDataSource(config);

        int threadCount = 5;
        Thread[] threads = new Thread[threadCount];

        long start = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new DBTask(ds), "Thread-" + i);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("Total time: " + (end - start) + " ms");

        ds.close();
    }
}