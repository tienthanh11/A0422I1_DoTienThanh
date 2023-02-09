package com.codegym.example1.service.impl;

import com.codegym.example1.model.Product;
import com.codegym.example1.repository.IProductRepository;
import com.codegym.example1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public Page<Product> findAllByName(String name,String manufacturer, Pageable pageable) {
        return productRepository.findAllByName(name,manufacturer,pageable);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product>product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateStatusById(Long id) {
        productRepository.updateStatusById(id);
    }
}
