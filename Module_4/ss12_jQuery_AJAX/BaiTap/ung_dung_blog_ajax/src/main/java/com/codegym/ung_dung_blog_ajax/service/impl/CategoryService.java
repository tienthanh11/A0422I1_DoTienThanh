package com.codegym.ung_dung_blog_ajax.service.impl;

import com.codegym.ung_dung_blog_ajax.model.Category;
import com.codegym.ung_dung_blog_ajax.repository.ICategoryRepository;
import com.codegym.ung_dung_blog_ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer category_id) {
        return categoryRepository.findById(category_id);
    }
}
