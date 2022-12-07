package com.codegym.repository;

import com.codegym.entity.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAllMusic();

    void create(Music music);

    void update(Music music);

    void delete(String name);

    Music findMusicByName(String nameSong);
}
