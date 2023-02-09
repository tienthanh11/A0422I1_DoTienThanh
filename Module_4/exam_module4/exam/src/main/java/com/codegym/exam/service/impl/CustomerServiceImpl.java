package com.codegym.exam.service.impl;

import com.codegym.exam.model.Customer;
import com.codegym.exam.repository.ICustomerRepository;
import com.codegym.exam.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
