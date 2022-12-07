package com.codegym.entity;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {

    private String nameSong;
    private String singer;
    private String typeOfMusic;
    private MultipartFile path;

    public MusicForm() {
    }

    public MusicForm(String nameSong, String singer, String typeOfMusic, MultipartFile path) {
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

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
