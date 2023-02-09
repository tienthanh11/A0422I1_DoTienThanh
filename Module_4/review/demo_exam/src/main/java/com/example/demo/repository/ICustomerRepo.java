package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, String> {
    Page<Customer>findAllByNameCustomerContaining(String name, Pageable pageable);
    Page<Customer>findAllByCustomerTypeId(Integer id, Pageable pageable);
}
