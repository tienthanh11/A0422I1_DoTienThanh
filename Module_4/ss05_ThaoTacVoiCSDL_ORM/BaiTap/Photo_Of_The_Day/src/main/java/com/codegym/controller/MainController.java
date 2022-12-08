package com.codegym.controller;

import com.codegym.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String goIndex(Model model) {
        model.addAttribute("comment", new Comment());
        return "/index";
    }
}