/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator8;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Miruna
 */

class TestDatabase {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/laborator8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private Database database;

    @BeforeEach
    void setUp() {
        database = Database.getInstance();
    }

    @AfterEach
    void tearDown() throws SQLException {
        Database.closeConnection();
    }

    @Test
    void testGetInstance() {
        assertNotNull(database);
        assertSame(database, Database.getInstance());
    }

    @Test
    void testGetConnection() {
        Connection connection = Database.getConnection();
        assertNotNull(connection);
        assertSame(connection, Database.getConnection());
    }

    @Test
    void testCloseConnection() throws SQLException {
        Connection connection = Database.getConnection();
        assertFalse(connection.isClosed());
        Database.closeConnection();
        assertTrue(connection.isClosed());
    }

}