package com.codegym.validate_thong_tin_bai_hat.service;

import com.codegym.validate_thong_tin_bai_hat.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAllMusic();

    void create(Music music);

    void update(Music music);

    void delete(String name);

    Music findMusicByName(String nameSong);
}
