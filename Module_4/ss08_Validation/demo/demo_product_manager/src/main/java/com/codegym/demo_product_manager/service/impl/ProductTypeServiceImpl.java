package com.codegym.demo_product_manager.service.impl;

import com.codegym.demo_product_manager.model.ProductType;
import com.codegym.demo_product_manager.repository.IProductTypeRepository;
import com.codegym.demo_product_manager.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findById(Integer id) {
        return productTypeRepository.findById(id).orElse(null);
    }
}
