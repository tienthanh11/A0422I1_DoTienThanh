package com.codegym.demo_aop.controller;

import com.codegym.demo_aop.model.Book;
import com.codegym.demo_aop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestController {

    @Autowired
    IBookService bookService;

    @RequestMapping(value = "/searchNameBook", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Book> searchNameBook(@RequestParam(name = "nameBook", required = false, defaultValue = "") String name) {
        List<Book> books =bookService.findByName(name);
        return books;
    }
}
