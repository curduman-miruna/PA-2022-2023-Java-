/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laborator8;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Miruna
 */


public class Laborator8 {
    public static void main(String[] args) throws SQLException {

        try {

            // creating singleton instance
            Database.getInstance();

            Statement stmt = Database.getConnection().createStatement();

            // reading and executing the sql script
            String script = new String(Files.readAllBytes(Paths.get("create_tables.sql")));
            stmt.execute(script);

            stmt.close();

            // adding entries in artists table
            var artists = new ArtistDAO();
            artists.create("BlackPink");
            artists.create("Beatles");


            Database.closeConnection();
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
