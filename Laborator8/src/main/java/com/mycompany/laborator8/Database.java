package com.mycompany.laborator8;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/laborator8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private static final DataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);

        dataSource = new HikariDataSource(config);
    }

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
