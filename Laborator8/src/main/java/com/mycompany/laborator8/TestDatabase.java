package com.mycompany.laborator8;

import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class TestDatabase {

    private static final String URL = "jdbc:postgresql://localhost:5432/laborator8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        Connection connection = Database.getConnection();
    }

    @AfterEach
    void tearDown() throws SQLException {
        Connection connection = null;
        try {
            connection = Database.getConnection();
            // do something with the connection
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                Database.closeConnection(connection);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Test
    void testGetConnection() throws SQLException {
        Connection connection = Database.getConnection();
        assertNotNull(connection);
        assertSame(connection, Database.getConnection());
    }

    @Test
    void testCloseConnection() throws SQLException {
        Connection connection = Database.getConnection();
        assertFalse(connection.isClosed());

        Database.closeConnection(connection);

        assertTrue(connection.isClosed());
    }

}
