package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepo;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepo customerRepo;

    @Override
    public void create(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepo.findById(id);
    }

    @Override
    public Page search(String name, Pageable pageable) {
        return (Page) customerRepo.findAllByNameCustomerContaining(name, pageable);
    }


}
