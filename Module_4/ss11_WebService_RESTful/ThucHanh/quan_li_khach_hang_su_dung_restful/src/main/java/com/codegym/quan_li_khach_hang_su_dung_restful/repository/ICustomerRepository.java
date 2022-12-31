package com.codegym.quan_li_khach_hang_su_dung_restful.repository;

import com.codegym.quan_li_khach_hang_su_dung_restful.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
