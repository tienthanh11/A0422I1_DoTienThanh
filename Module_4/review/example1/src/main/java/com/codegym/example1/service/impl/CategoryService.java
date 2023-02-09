package com.codegym.example1.service.impl;

import com.codegym.example1.model.Category;
import com.codegym.example1.repository.ICategoryRepository;
import com.codegym.example1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
