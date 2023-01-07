package com.codegym.ung_dung_blog_ajax.service.impl;

import com.codegym.ung_dung_blog_ajax.model.Blog;
import com.codegym.ung_dung_blog_ajax.repository.IBlogRepository;
import com.codegym.ung_dung_blog_ajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByCategory(String category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public List<Blog> findAllByKey(String key) {
        return blogRepository.findAllByKey(key);
    }
}
