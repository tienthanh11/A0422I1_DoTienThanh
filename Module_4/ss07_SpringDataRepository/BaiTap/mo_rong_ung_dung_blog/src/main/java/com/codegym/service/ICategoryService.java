package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    void create(Category category);

    void update(Category category);

    void delete(Integer id);

    List<Category> findAll();

    Category findById(Integer id);
}
