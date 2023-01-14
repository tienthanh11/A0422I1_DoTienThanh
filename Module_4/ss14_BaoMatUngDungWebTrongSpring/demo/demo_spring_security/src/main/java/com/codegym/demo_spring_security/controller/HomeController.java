package com.codegym.demo_spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/user/index")
    public String user_index() {
        return "user";
    }
    @GetMapping("/admin/index")
    public String admin_index() {
        return "admin";
    }

    @GetMapping("/deny")
    public String deny() {
        return "deny";
    }

    @GetMapping("login")
    public String showLogin() {
        return "login";
    }
}
