package com.codegym.ung_dung_blog_ajax.service;

import com.codegym.ung_dung_blog_ajax.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();

    Optional<Category> findById(Integer category_id);
}
