/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator8.DAO;

import Models.Artist;
import Models.Genre;
import com.mycompany.laborator8.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miruna
 */
public class ArtistDAO {

    private int id; //maximum id in the table
    private Connection con;

    public ArtistDAO(Connection con) throws SQLException {
        this.con = con;
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select max(id) from artists")) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }

    }

    public void create(Artist artist) throws SQLException {
        if (this.findByName(artist.getName()) == null) {
            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select max(id) from artists")) {
                if (rs.next()) {
                    id = rs.getInt(1) + 1;
                }
            }
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into artists (id, name) values (?, ?)")) {
                pstmt.setInt(1, id);
                pstmt.setString(2, artist.getName());
                artist.setId(id);
                pstmt.executeUpdate();
            }
        } else {
            System.out.println(artist.getName() + "is already in the table with the id: " + this.findByName(artist.getName()));
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select name from artists where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public List<Artist> findAll() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        PreparedStatement pstmt = con.prepareStatement("SELECT id, name FROM artists");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Artist artist = new Artist(id, name);
            artists.add(artist);
        }

        return artists;
    }

    public void updateTitle(int id, String title) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "update artists set name=? where id=?")) {
            pstmt.setString(1, title);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from artists where id=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
