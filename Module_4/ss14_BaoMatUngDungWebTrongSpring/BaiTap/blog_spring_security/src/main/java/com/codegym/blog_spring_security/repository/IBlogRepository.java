package com.codegym.blog_spring_security.repository;

import com.codegym.blog_spring_security.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
