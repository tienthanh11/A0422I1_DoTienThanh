package com.codegym.blog_spring_security.controller;

import com.codegym.blog_spring_security.dto.BlogDTO;
import com.codegym.blog_spring_security.model.Blog;
import com.codegym.blog_spring_security.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("/*")
public class APIBlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Blog> createData(@Valid @RequestBody BlogDTO blogDTO) {
        return new ResponseEntity<>(blogService.save(new Blog(blogDTO)), HttpStatus.CREATED);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Blog> editData(@Valid @RequestBody BlogDTO blogDTO) {
        Blog blog = new Blog(blogDTO);
        blog.setId(blogDTO.getId());
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Blog>> deleteData(@PathVariable Long id) {
        blogService.remove(id);
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.NO_CONTENT);
    }
}
