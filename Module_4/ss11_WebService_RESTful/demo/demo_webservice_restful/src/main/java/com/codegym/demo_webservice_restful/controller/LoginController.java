package com.codegym.demo_webservice_restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin() {
        return "student/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model, HttpSession session) {
        if ("root".equals(username) && "123456".equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/student/list";
        }
        model.addAttribute("error", "Login failed. Username or password doesn't correct");
        return "student/login";
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/login";
    }

}
