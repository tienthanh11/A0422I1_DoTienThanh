package com.codegym.demo_product_manager.service;

import com.codegym.demo_product_manager.model.Product;

import java.util.List;

public interface IProductService {
    void create(Product product);

    void update(Product product);

    void delete(Integer id);

    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByName(String name);
}
