package com.codegym.ung_dung_blog_ajax.repository;

import com.codegym.ung_dung_blog_ajax.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog b join category c on b.category_id = c.category_id where c.category_id like ?1", nativeQuery = true)
    List<Blog> findAllByCategory(String category);

    @Query(value = "select * from blog b join category c on b.category_id = c.category_id where b.author like ?1 or b.body like ?1", nativeQuery = true)
    List<Blog> findAllByKey(String key);
}
