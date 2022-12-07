package com.codegym.service;

import com.codegym.entity.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAllMusic();

    void create(Music music);

    void update(Music music);

    void delete(String name);

    Music findMusicByName(String nameSong);
}
