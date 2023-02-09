package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    void create(Customer customer);

    void update(Customer customer);

    void delete(String id);

    Page findAll(Pageable pageable);

    Optional<Customer> findById(String id);

    Page search(String name, Pageable pageable);
}
