package com.codegym.blog_application_restful.controller;

import com.codegym.blog_application_restful.model.Category;
import com.codegym.blog_application_restful.model.Writing;
import com.codegym.blog_application_restful.service.CategoryService;
import com.codegym.blog_application_restful.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/writing")
public class RestWritingController {

    @Autowired
    private WritingService writingService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAllNoSort();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Writing>> list() {
        Iterable<Writing> writings = writingService.findAllNoSort();
        if (writings == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(writings, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> create(@RequestBody Writing writing, UriComponentsBuilder uriComponentsBuilder) {
        writing.setTime(new Date());
        writingService.save(writing);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/writing/{id}").buildAndExpand(writing.getId()).toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Writing> edit(@PathVariable("id") Long id, @RequestBody Writing writing) {
        Writing currentWriting = writingService.findById(id);
        if ((writing == null) || (currentWriting == null)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentWriting.setCategory(writing.getCategory());
        currentWriting.setTittle(writing.getTittle());
        currentWriting.setContent(writing.getContent());
        writingService.save(currentWriting);
        return new ResponseEntity<>(currentWriting, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Writing> view(@PathVariable("id") Writing writing) {
        if (writing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(writing, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Writing> remove(@PathVariable("id") Writing writing) {
        if (writing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
