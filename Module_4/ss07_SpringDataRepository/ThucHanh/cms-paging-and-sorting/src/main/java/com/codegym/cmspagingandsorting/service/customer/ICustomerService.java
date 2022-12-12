package com.codegym.cmspagingandsorting.service.customer;


import com.codegym.cmspagingandsorting.model.Customer;
import com.codegym.cmspagingandsorting.model.Province;
import com.codegym.cmspagingandsorting.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
