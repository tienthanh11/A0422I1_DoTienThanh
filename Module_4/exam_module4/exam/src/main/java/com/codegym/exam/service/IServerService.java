package com.codegym.exam.service;

import com.codegym.exam.model.Customer;
import com.codegym.exam.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServerService {

    Page<Service> findAll(Pageable pageable);

    Page<Service> search(String serviceType, String customerId, Pageable pageable);

    List<Service> findAll();

    void save(Service service);

    void delete(Integer id);

    Service findById(Integer id);

}
