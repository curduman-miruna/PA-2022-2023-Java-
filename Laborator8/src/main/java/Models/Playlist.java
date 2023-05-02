/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 *
 * @author Miruna
 */
public class Playlist {

    private int id;
    private String name;
    private Timestamp createdAt;
    private String[] albumArray;

    public Playlist(int id, String name, Timestamp createdAt, String albumArray) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        String[] albumsArray = albumArray.split(",");
        this.albumArray = albumsArray;
    }

    public Playlist(String name, String albumArray) {
        this.id = id;
        this.name = name;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        String[] albumsArray = albumArray.split(",");
        this.albumArray = albumsArray;
    }

    public Playlist(String name, Timestamp createdAt, String albumArray) {
        this.id = 1;
        this.name = name;
        this.createdAt = createdAt;
        String[] albumsArray = albumArray.split(",");
        this.albumArray = albumsArray;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String[] getAlbumArray() {
        return this.albumArray;
    }

    public void setAlbumArray(String[] albumArray) {
        this.albumArray = albumArray;
    }

    @Override
    public String toString() {
        return "Playlist{" + "id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", albumArray=" + Arrays.toString(albumArray) + '}';
    }

}
