package com.codegym.phone_manager.controller;

import com.codegym.phone_manager.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    IPhoneService phoneService;

    @GetMapping("")
    public String getHome() {
        return "list";
    }
}
