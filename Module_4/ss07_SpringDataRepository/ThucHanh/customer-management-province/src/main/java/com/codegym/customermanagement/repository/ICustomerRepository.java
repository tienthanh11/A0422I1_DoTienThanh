package com.codegym.customermanagement.repository;

import com.codegym.customermanagement.model.Customer;
import com.codegym.customermanagement.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
