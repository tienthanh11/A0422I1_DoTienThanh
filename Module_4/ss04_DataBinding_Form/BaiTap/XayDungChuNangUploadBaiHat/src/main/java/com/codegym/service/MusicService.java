package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.repository.IMusicRepository;
import com.codegym.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    IMusicRepository musicRepository;

    @Override
    public List<Music> getAll() {
        return musicRepository.getAll();
    }

    @Override
    public void saveSong(Music music) {
        musicRepository.saveSong(music);
    }

    @Override
    public String saveFile(MusicForm musicForm, String fileUpload) throws IOException {
        MultipartFile multipartFile = musicForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if ("".equals(fileName)) {
            return fileName;
        } else if(Validate.checkFileType(fileName)) {
            musicRepository.saveFile(musicForm, fileUpload, fileName);
            return fileName;
        } else {
            fileName = "Error Input";
            return fileName;
        }
    }
}
