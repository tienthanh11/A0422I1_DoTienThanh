package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void create(Blog blog);

    void update(Blog blog);

    void remove(Integer id);

    Blog findById(Integer id);

    List<Blog> search(String name);
}
