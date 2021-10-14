package com.example.songr;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int length;
    private int trackNumber;
    private String albumForSong;

    @ManyToOne
    private Album songAlbum;

    public Song(){}

    public Song(String title , int length, int trackNumber, Album songAlbum){
    this.title=title;
    this.length= length;
    this.trackNumber= trackNumber;
    this.songAlbum=songAlbum;
    this.albumForSong=this.songAlbum.getTitle();
    }

    public String getAlbumForSong() {
        return albumForSong;
    }

    public void setAlbumForSong(int albumForSong) {
        this.albumForSong = this.songAlbum.getTitle();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getSongAlbum() {

        return songAlbum;
    }

    public void setSongAlbum(Album songAlbum) {
        this.songAlbum = songAlbum;
    }
}
