package com.codegym.validate_thong_tin_bai_hat.service;

import com.codegym.validate_thong_tin_bai_hat.model.Music;
import com.codegym.validate_thong_tin_bai_hat.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    IMusicRepository musicRepository;

    @Override
    public List<Music> findAllMusic() {
        return musicRepository.findAll();
    }

    @Override
    public void create(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void update(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(String name) {
        musicRepository.deleteById(name);
    }

    @Override
    public Music findMusicByName(String nameSong) {
        return musicRepository.findById(nameSong).orElse(null);
    }
}
