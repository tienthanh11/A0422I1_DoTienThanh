package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByNameContaining(String name);
}
