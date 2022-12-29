package com.codegym.demo_aop.service;

import com.codegym.demo_aop.model.Book;
import com.codegym.demo_aop.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> getList() {
        Iterable<Book> iterable = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        for (Book book : iterable) {
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findAllByNameContains(name);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
