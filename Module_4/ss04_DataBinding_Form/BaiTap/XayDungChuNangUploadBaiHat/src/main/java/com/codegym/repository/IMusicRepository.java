package com.codegym.repository;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;

import java.io.IOException;
import java.util.List;

public interface IMusicRepository {
    List<Music> getAll();

    void saveSong(Music music);

    void saveFile(MusicForm musicForm, String fileUpload, String fileName) throws IOException;
}
