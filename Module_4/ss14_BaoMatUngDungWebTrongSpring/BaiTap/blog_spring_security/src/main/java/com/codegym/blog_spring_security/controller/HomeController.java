package com.codegym.blog_spring_security.controller;

import com.codegym.blog_spring_security.model.Category;
import com.codegym.blog_spring_security.service.IBlogService;
import com.codegym.blog_spring_security.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    List<Category> categoryList = Arrays.asList(Category.values());

    @Autowired
    IBlogService blogService;

    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("list", blogService.findAll());
        model.addAttribute("categoryList", categoryList);
        return "home";
    }

    @GetMapping("/login")
    public String goLogin() {
        return "/login";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thành công sẽ có principal
        String username = principal.getName();

        System.out.println("Username: " + username);

        User login = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(login);
        model.addAttribute("userInfo", userInfo);

        return "login";
    }
}
