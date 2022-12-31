package com.codegym.blog_application_restful.service;

import com.codegym.blog_application_restful.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Iterable<Category> findAllNoSort();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
