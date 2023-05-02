/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Arrays;

/**
 *
 * @author Miruna
 */
public class Album {

    private int id;
    private int releaseYear;
    private String title;
    private String artist;
    private String[] genre;

    public Album(int releaseYear, String title, String artist, String genre) {
        this.id = 1;//default
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        String[] genreArray = genre.split(",");
        this.genre = genreArray;
    }

    public Album(int id, int releaseYear, String title, String artist, String genre) {
        this.id = id;//default
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        String[] genreArray = genre.split(",");
        this.genre = genreArray;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Album " + title + "(" + Arrays.toString(genre) + ")" + " with the id - " + id + " was released in " + releaseYear + " by the artist - " + artist;

    }
}
