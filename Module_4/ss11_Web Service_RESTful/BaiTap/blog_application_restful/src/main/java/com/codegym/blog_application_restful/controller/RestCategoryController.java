package com.codegym.blog_application_restful.controller;

import com.codegym.blog_application_restful.model.Category;
import com.codegym.blog_application_restful.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/category")
public class RestCategoryController {

    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Category>> listCategory() {
        Iterable<Category> categories = categoryService.findAllNoSort();
        if (categories == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Category category, UriComponentsBuilder uriComponentsBuilder) {
        categoryService.save(category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> edit(@PathVariable("id") Category currentCategory, @RequestBody Category category) {
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(currentCategory.getId());
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> view(@PathVariable("id") Category category) {
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> remove(@PathVariable("id") Category category) {
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            categoryService.remove(category.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

