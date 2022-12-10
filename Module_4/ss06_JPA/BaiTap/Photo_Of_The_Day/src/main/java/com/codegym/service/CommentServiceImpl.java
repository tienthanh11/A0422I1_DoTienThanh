package com.codegym.service;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> getAllCommentByDate() {
        TypedQuery<Comment> query = entityManager.createQuery("select c from Comment c where current_date = c.createAt", Comment.class);
        return query.getResultList();
    }

    @Override
    public void incrementLike(Comment comment) {
        entityManager.merge(comment);
    }

    @Override
    public Comment getById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void insertComment(Comment comment) {
        commentRepository.save(comment);
    }
}
