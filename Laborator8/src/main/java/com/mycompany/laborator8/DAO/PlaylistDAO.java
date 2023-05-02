/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator8.DAO;

import Models.Playlist;
import com.mycompany.laborator8.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miruna
 */
public class PlaylistDAO {

    private int id; // maximum id in the table
    private Connection con;

    public PlaylistDAO(Connection connection) throws SQLException {
        con = connection;
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select max(id) from playlists")) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }
    }

    public void create(Playlist playlist) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select max(id) from playlists")) {
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into playlists (id, name, album_array) values (?, ?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, playlist.getName());
            playlist.setId(id);
            pstmt.setArray(3, con.createArrayOf("text", playlist.getAlbumArray()));
            pstmt.executeUpdate();
            playlist.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
    }

    public Playlist findById(int id) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("SELECT name, created_at, album_array FROM playlists WHERE id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            Timestamp createdAt = rs.getTimestamp("created_at");
            String albums = rs.getString("album_array");
            Playlist playlist = new Playlist(id, name, createdAt, albums);
            return playlist;
        }

        return null;
    }

    public List<Playlist> findAllPlaylists() throws SQLException {
        List<Playlist> playlists = new ArrayList<>();
        PreparedStatement pstmt = con.prepareStatement("SELECT id, name, created_at, album_array FROM playlists");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Timestamp createdAt = rs.getTimestamp("created_at");
            String albums = rs.getString("album_array");
            Playlist playlist = new Playlist(id, name, createdAt, albums);
            playlists.add(playlist);
        }

        return playlists;
    }

    public Playlist findByName(String name) throws SQLException {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id, created_at, album_array from playlists where name='" + name + "'")) {
            if (rs.next()) {
                int id = rs.getInt(1);
                Timestamp createdAt = rs.getTimestamp("created_at");
                String albums = rs.getString("album_array");
                Playlist playlist = new Playlist(id, name, createdAt, albums);
                return playlist;
            }
            return null;
        }
    }

    public void updateName(int id, String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "update playlists set name=? where id=?")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from playlists where id=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public List<String> getAlbums(int id) throws SQLException {
        List<String> albums = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(
                "select album_array from playlists where id=?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String[] albumsArray = (String[]) rs.getArray(1).getArray();
                    for (String album : albumsArray) {
                        albums.add(album);
                    }
                }
            }
        }
        return albums;
    }

    public int getId() {
        return id;
    }

}
