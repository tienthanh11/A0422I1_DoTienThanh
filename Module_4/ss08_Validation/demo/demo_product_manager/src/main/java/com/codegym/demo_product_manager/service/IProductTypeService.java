package com.codegym.demo_product_manager.service;

import com.codegym.demo_product_manager.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();

    ProductType findById(Integer id);
}
