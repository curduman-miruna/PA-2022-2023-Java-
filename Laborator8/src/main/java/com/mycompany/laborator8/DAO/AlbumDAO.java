/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Miruna
 */
package com.mycompany.laborator8.DAO;

import Models.Album;
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
public class AlbumDAO {

    private int id; //maximum id in the table
    private Connection con;

    public AlbumDAO(Connection con) throws SQLException {
        this.con = con;
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select max(id) from albums")) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }

    }

    public void create(Album album) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select max(id) from albums")) {
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id, release_year, title, artist, genre) values (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, album.getReleaseYear());
            pstmt.setString(3, album.getTitle());
            pstmt.setString(4, album.getArtist());
            pstmt.setArray(5, con.createArrayOf("text", album.getGenre()));
            pstmt.executeUpdate();
            album.setId(id);
        }

        // create album-genre associations
        AlbumGenresDAO albumGenreDao = new AlbumGenresDAO(con);
        GenreDAO genreDAO = new GenreDAO(con);
        for (String genre : album.getGenre()) {
            Integer genreId = genreDAO.findByName(genre);
            if (genreId != null) {
                albumGenreDao.create(id, genreId);
            }
        }
    }

    public String findById(int id) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select title from albums where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from albums where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public List<Album> findAll() throws SQLException {
        List<Album> albums = new ArrayList<>();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM albums");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int releaseYear = rs.getInt("release_year");
            String title = rs.getString("title");
            String artist = rs.getString("artist");
            String genres = rs.getString("genre");
            Album album = new Album(id, releaseYear, title, artist, genres);
            albums.add(album);
        }

        return albums;
    }

    public void updateTitle(int id, String title) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "update albums set title=? where id=?")) {
            pstmt.setString(1, title);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from albums where id=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
