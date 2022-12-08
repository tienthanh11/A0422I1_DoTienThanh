package com.codegym.controller;

import com.codegym.entity.Music;
import com.codegym.entity.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:music.properties")
@RequestMapping("/music")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    IMusicService musicService;

    @ModelAttribute("musicForm")
    public MusicForm initMusicForm() {
        return new MusicForm();
    }

    @ModelAttribute("music")
    public Music initMusic() {
        return new Music();
    }

    @GetMapping("")
    public String displayList(Model model) {
        List<Music> musicList = musicService.findAllMusic();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate() {
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("musicForm") MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getPath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getNameSong(), musicForm.getSinger(),
                musicForm.getTypeOfMusic(), fileName);
        musicService.create(music);
        return "redirect:/music/";
    }

    @GetMapping("/edit/{name}")
    public String showFormEdit(@PathVariable String name, Model model) {
        Music music = musicService.findMusicByName(name);
        model.addAttribute("music", music);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("music") Music music) {
        musicService.create(music);
        return "redirect:/music/";
    }

    @GetMapping("/delete/{name}")
    public String showFormDelete(@PathVariable("name") String name, Model model) {
        Music music = musicService.findMusicByName(name);
        model.addAttribute("music", music);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("music") Music music) {
        musicService.delete(music.getNameSong());
        return "redirect:/music/";
    }

    @GetMapping("/view/{name}")
    public String view(@PathVariable("name") String name, Model model) {
        Music music = musicService.findMusicByName(name);
        model.addAttribute("music", music);
        return "view";
    }
}
