package com.codegym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "music")
@Table
public class Music {
    @Column(name = "name_song", columnDefinition = " varchar(250)")
    @Id
    private String nameSong;
    private String singer;
    private String typeOfMusic;
    private String path;

    public Music() {
    }

    public Music(String nameSong, String singer, String typeOfMusic, String path) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.typeOfMusic = typeOfMusic;
        this.path = path;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
