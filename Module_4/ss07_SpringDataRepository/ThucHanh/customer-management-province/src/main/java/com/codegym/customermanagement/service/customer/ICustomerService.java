package com.codegym.customermanagement.service.customer;

import com.codegym.customermanagement.model.Customer;
import com.codegym.customermanagement.model.Province;
import com.codegym.customermanagement.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
