package com.codegym.blog_application_restful.repository;

import com.codegym.blog_application_restful.model.Category;
import com.codegym.blog_application_restful.model.Writing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingRepository extends PagingAndSortingRepository<Writing, Long> {
    Iterable<Writing> findAllByCategory(Category category);

    Page<Writing> findAllByTittleContaining(String tittle, Pageable pageable);
}
