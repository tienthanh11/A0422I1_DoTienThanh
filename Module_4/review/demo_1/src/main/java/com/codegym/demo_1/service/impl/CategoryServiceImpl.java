package com.codegym.demo_1.service.impl;

import com.codegym.demo_1.model.Category;
import com.codegym.demo_1.repository.ICategoryRepository;
import com.codegym.demo_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
