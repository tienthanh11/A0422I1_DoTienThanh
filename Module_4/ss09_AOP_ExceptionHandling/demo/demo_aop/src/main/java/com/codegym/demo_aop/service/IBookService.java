package com.codegym.demo_aop.service;

import com.codegym.demo_aop.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> getList();

    void save(Book book);

    void update(Book book);

    void deleteBookById(int id);

    Book getBookById(int id);

    List<Book> findByName(String name);

    Page<Book> findAll(Pageable pageable);
}
