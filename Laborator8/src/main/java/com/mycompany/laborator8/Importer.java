/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Importer {

    private static final String DATA_FILE = "albumlist.csv";
    private static final String INSERT_SQL = "INSERT INTO albums (id, release_year, title, artist, genre) VALUES (?, ?, ?, ?, ?)";

    public int execute(Connection conection, int id) throws SQLException, FileNotFoundException, IOException {
        PreparedStatement stmt = conection.prepareStatement(INSERT_SQL);

        // Read the data file and insert each album
        BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE));
        String line;
        line = reader.readLine();//first one
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            int year = Integer.parseInt(fields[1]);
            String title = fields[2];
            String artist = fields[3];
            String[] genres = fields[4].split(",");

            stmt.setInt(1, ++id);
            stmt.setInt(2, year);
            stmt.setString(3, title);
            stmt.setString(4, artist);
            stmt.setArray(5, conection.createArrayOf("text", genres));

            stmt.executeUpdate();
        }
        reader.close();
        System.out.println("Data import completed successfully.");
        return id;
    }
}
