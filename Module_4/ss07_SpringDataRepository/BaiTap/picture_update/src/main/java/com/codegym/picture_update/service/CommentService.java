package com.codegym.picture_update.service;

import com.codegym.picture_update.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<Comment> getAllCommentByDate(Pageable pageable);

    void incrementLike(Comment comment);

    Comment getById(int id);

    void insertComment(Comment comment);
}
