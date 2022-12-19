package com.codegym.validate_thong_tin_bai_hat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "music")
public class Music {
    @Id
    @Column(name = "name_song", columnDefinition = "varchar(250)")
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
