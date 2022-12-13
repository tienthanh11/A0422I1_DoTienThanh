package com.codegym.picture_update.repository;

import com.codegym.picture_update.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Page<Comment> findAllByCreateAtOrderByCreateAt(Pageable pageable);
}
