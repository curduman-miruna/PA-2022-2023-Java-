/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator8.DAO;

import Models.Genre;
import com.mycompany.laborator8.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miruna
 */
public class GenreDAO {

    private int id; //maximum id in the 
    private Connection con;

    public GenreDAO(Connection con) throws SQLException {
        this.con = con;
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select max(id) from genres")) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }

    }

    public void create(Genre genre) throws SQLException {
        if (this.findByName(genre.getName()) == null) {
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select max(id) from genres")) {
                if (rs.next()) {
                    id = rs.getInt(1) + 1;
                }
            }
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into genres (id, name) values (?, ?)")) {
                pstmt.setInt(1, id);
                genre.setId(id);
                pstmt.setString(2, genre.getName());
                pstmt.executeUpdate();
            }
        } else {
            System.out.println(genre.getName() + "is already in the table with the id: " + this.findByName(genre.getName()));
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select name from genres where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public void updateTitle(int id, String title) throws SQLException {;
        try (PreparedStatement pstmt = con.prepareStatement(
                "update genres set name=? where id=?")) {
            pstmt.setString(1, title);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public List<Genre> findAll() throws SQLException {
        List<Genre> genres = new ArrayList<>();
        PreparedStatement pstmt = con.prepareStatement("SELECT id, name FROM genres");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Genre genre = new Genre(id, name);
            genres.add(genre);
        }

        return genres;
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from genres where id=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public int getId() {
        return id;
    }

}
