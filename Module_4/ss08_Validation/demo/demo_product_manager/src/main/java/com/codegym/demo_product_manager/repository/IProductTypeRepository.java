package com.codegym.demo_product_manager.repository;

import com.codegym.demo_product_manager.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
