package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;

import java.io.IOException;
import java.util.List;

public interface IMusicService {
    List<Music> getAll();

    void saveSong(Music music);

    String saveFile(MusicForm musicForm, String fileUpload) throws IOException;
}
