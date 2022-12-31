package com.codegym.blog_application_restful.service;

import com.codegym.blog_application_restful.model.Category;
import com.codegym.blog_application_restful.model.Writing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WritingService {
    Page<Writing> findAll(Pageable pageable);

    Iterable<Writing> findAllNoSort();

    Writing findById(Long id);

    void save(Writing writing);

    void remove(Long id);

    Iterable<Writing> findAllByCategory(Category category);

    Page<Writing> findAllByTittleContaining(String tittle, Pageable pageable);
}