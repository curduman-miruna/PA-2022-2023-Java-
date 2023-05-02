/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator8.DAO;

import Models.AlbumGenre;
import Models.Artist;
import com.mycompany.laborator8.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miruna
 */
public class AlbumGenresDAO {

    private Connection con;

    public AlbumGenresDAO(Connection con) {
        this.con = con;
    }

    public void create(int albumId, int genreId) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into album_genres (album_id, genre_id) values (?, ?)")) {
            pstmt.setInt(1, albumId);
            pstmt.setInt(2, genreId);
            pstmt.executeUpdate();
        }
    }

    public List<AlbumGenre> findAll() throws SQLException {
        List<AlbumGenre> albumgenres = new ArrayList<>();
        PreparedStatement pstmt = con.prepareStatement("SELECT album_id, genre_id FROM album_genres");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id1 = rs.getInt("album_id");
            int id2 = rs.getInt("genre_id");
            AlbumGenre albumgenre = new AlbumGenre(id1, id2);
            albumgenres.add(albumgenre);
        }

        return albumgenres;
    }

    public List<Integer> findGenresForAlbum(int albumId) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "select genre_id from album_genres where album_id = ?")) {
            pstmt.setInt(1, albumId);
            ResultSet rs = pstmt.executeQuery();
            List<Integer> genres = new ArrayList<>();
            while (rs.next()) {
                genres.add(rs.getInt("genre_id"));
            }
            return genres;
        }
    }
}
