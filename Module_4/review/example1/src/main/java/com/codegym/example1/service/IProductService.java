package com.codegym.example1.service;

import com.codegym.example1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllByName(String name,String manufacturer, Pageable pageable);

    Product findById(Long id);

    void save(Product product);

    void updateStatusById(Long id);
}
