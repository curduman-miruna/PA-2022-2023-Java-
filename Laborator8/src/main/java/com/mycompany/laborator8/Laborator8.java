/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laborator8;

import Models.Album;
import Models.AlbumGenre;
import Models.Artist;
import Models.Genre;
import Models.Playlist;
import com.mycompany.laborator8.DAO.AlbumDAO;
import com.mycompany.laborator8.DAO.AlbumGenresDAO;
import com.mycompany.laborator8.DAO.ArtistDAO;
import com.mycompany.laborator8.DAO.GenreDAO;
import com.mycompany.laborator8.DAO.PlaylistDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miruna
 */
public class Laborator8 {

    public static void main(String[] args) throws SQLException {
        try {
            // creating singleton instance
            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();

            // reading and executing the sql script
            String script = new String(Files.readAllBytes(Paths.get("create_tables.sql")));
            stmt.execute(script);

            stmt.close();

            // adding entries in artists table
            var artists = new ArtistDAO(connection);
            artists.create(new Artist("Pink Floyd"));
            artists.create(new Artist("Michael Jackson"));
            artists.create(new Artist("Michael Jackson"));
            List<Artist> artistList = artists.findAll();
            for (Artist artist : artistList) {
                System.out.println(artist.toString());
            }

            var genres = new GenreDAO(connection);
            genres.create(new Genre("Rock"));
            genres.create(new Genre("Funk"));
            genres.create(new Genre("Jazz"));
            genres.create(new Genre("Pop"));
            genres.create(new Genre("Soul"));
            List<Genre> genreList = genres.findAll();
            for (Genre genre : genreList) {
                System.out.println(genre.toString());
            }

            var albums = new AlbumDAO(connection);
            var albumsGenres = new AlbumGenresDAO(connection);
            albums.create(new Album(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop"));
            albums.create(new Album(1982, "Girls Have fun", "Katty Perry", "Pop"));
            albums.create(new Album(1982, "Me", "MichELE", "Funk,Pop"));
            List<Album> albumsList = albums.findAll();
            for (Album album : albumsList) {
                System.out.println(album.toString());
            }

            List<AlbumGenre> albumGenreList = albumsGenres.findAll();
            for (AlbumGenre albumGenre : albumGenreList) {
                System.out.println(albumGenre.toString());
            }

            System.out.println("The maximum id now is " + albums.getId());
            var importer = new Importer();
            albums.setId(importer.execute(connection, albums.getId()));
            System.out.println("The maximum id now is " + albums.getId());
            var playlists = new PlaylistDAO(connection);
            playlists.create(new Playlist("My Favorite Albums", "The Wall, Thriller"));
            List<Playlist> playLists = playlists.findAllPlaylists();
            for (Playlist playlist : playLists) {
                System.out.println(playlist.toString());
            }

            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
