package com.codegym.validate_form_register.controller;

import com.codegym.validate_form_register.model.User;
import com.codegym.validate_form_register.service.IUserService;
import com.codegym.validate_form_register.validate.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/create";
    }

    @PostMapping("/register")
    public String validate(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        UserValidation userValidation = new UserValidation();
        userValidation.validate(user, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("message", "Unsuccessful");
            return "/create";
        } else {
            model.addAttribute("message", "Successful");
            userService.save(user);
            return "/result";
        }
    }
}
