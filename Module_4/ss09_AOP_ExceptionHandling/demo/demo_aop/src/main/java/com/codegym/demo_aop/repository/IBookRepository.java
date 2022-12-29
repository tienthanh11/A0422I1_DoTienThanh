package com.codegym.demo_aop.repository;

import com.codegym.demo_aop.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book, Integer> {
    List<Book> findAllByNameContains(String name);

    @Query("select b from Book b where b.name like :name")
    List<Book> searchAllByName(String name);
}
