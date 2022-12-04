package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@PropertySource("classpath:upload_music.properties")
@RequestMapping("/music")
public class MusicUploadController {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    IMusicService musicService;

/*    @GetMapping("")
    public String showHome (Model model) {
        List<Music> musicList = musicService.getAll();
        model.addAttribute("musicList", musicList);
        return "/home";
    }*/

    @GetMapping("")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("/home", "songs", musicService.getAll());
        return modelAndView;
    }


    @GetMapping("/showUpload")
    public String showUpload(Model model) {
        model.addAttribute("musicForm", new MusicForm("", "", "", null));
        return "/upload";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute("musicForm") MusicForm musicForm, RedirectAttributes redirectAttributes) throws IOException {
        String mess = "";
        String fileName = musicService.saveFile(musicForm, fileUpload);
        if ("Wrong input".equals(fileName)) {
            mess = "Wrong input file type";
        } else if ("".equals(fileName)) {
            mess = "Can not add new song because of missing file upload";
        } else {
            Music music = new Music(musicForm.getName(), musicForm.getSinger(), musicForm.getType(), fileName);
            musicService.saveSong(music);
            mess = "Upload successfully";
        }
        redirectAttributes.addFlashAttribute("msg", mess);
        return "redirect:/";
    }
}
