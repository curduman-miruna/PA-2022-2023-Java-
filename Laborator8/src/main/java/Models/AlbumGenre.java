/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Miruna
 */
public class AlbumGenre {

    private int albumId;
    private int genreId;

    public AlbumGenre(int albumId, int genreId) {
        this.albumId = albumId;
        this.genreId = genreId;
    }

    // getters and setters
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Album with id=" + albumId + ", has the genre with the id=" + genreId;
    }

}
