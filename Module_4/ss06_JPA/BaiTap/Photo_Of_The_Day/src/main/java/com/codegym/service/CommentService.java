package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentByDate();

    void incrementLike(Comment comment);

    Comment getById(int id);

    void insertComment(Comment comment);
}
