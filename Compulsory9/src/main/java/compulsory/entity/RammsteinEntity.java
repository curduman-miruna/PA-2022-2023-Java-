package compulsory.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(name = "RammsteinEntity.findByName", query = "SELECT r FROM RammsteinEntity r WHERE r.songName LIKE :songName")
@NamedQuery(name = "RammsteinEntity.findByAlbum", query = "SELECT r FROM RammsteinEntity r WHERE r.album LIKE :album")

@Table(name = "RAMMSTEIN", schema = "student")
public class RammsteinEntity {

    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "SONG_NAME")
    private String songName;
    @Basic
    @Column(name = "ALBUM")
    private String album;
    @Basic
    @Column(name = "DURATION")
    private String duration;
    @Basic
    @Column(name = "RELEASE_DATE")
    private String releaseDate;

    public RammsteinEntity() {

    }

    public int getId() {
        return id;
    }

    public RammsteinEntity(int id, String songName, String album, String duration, String releaseDate) {
        this.id = id;
        this.songName = songName;
        this.album = album;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RammsteinEntity that = (RammsteinEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (songName != null ? !songName.equals(that.songName) : that.songName != null) return false;
        if (album != null ? !album.equals(that.album) : that.album != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "\nRammstein song no. " + id + " on album '" + album + "' - " + songName + " - " + duration + " , released on " + releaseDate + " ";
    }
}
