package com.codegym.demo_aop.controller;

import com.codegym.demo_aop.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("user") User user, Model model) {
        String errorMessage = null;
        if (!"root".equals(user.getUsername())) {
            errorMessage = "User not found";
        } else if (!"123456".equals(user.getPassword())) {
            errorMessage = "Password don't correct";
        } else {
            return "redirect:/book/list";
        }

        model.addAttribute("message", errorMessage);
        return "login";
    }
}