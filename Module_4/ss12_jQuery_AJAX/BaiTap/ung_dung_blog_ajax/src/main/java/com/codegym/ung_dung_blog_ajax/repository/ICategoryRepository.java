package com.codegym.ung_dung_blog_ajax.repository;

import com.codegym.ung_dung_blog_ajax.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
