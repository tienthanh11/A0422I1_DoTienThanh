package com.example.demo.service.impl;

import com.example.demo.model.CustomerType;
import com.example.demo.repository.ICustomerTypeRepo;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepo customerTypeRepo;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepo.findAll();
    }
}
