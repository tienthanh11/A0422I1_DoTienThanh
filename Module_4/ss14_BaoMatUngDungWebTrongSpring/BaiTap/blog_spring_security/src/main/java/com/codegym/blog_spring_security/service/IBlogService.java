package com.codegym.blog_spring_security.service;

import com.codegym.blog_spring_security.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog save(Blog blog);

    void remove(Long id);
}
