package com.codegym.demo_aop.controller;

import com.codegym.demo_aop.exception.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/index")
    public String index() throws UserException {
        throw new UserException("index demo");
    }
}
