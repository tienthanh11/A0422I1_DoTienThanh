package com.codegym.exam.service;

import com.codegym.exam.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
