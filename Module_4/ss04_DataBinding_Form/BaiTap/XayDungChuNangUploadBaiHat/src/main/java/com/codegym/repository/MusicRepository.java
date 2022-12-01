package com.codegym.repository;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {

    private List<Music> musicList = new ArrayList<>();

    @Override
    public List<Music> getAll() {
        return musicList;
    }

    @Override
    public void saveSong(Music music) {
        musicList.add(music);
    }

    @Override
    public void saveFile(MusicForm musicForm, String fileUpload, String fileName) throws IOException {
        FileCopyUtils.copy(musicForm.getSong().getBytes(), new File(fileUpload + fileName));
    }
}
