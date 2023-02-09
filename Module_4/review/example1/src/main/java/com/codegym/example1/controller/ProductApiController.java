package com.codegym.example1.controller;

import com.codegym.example1.model.Product;
import com.codegym.example1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin("/*")

public class ProductApiController {
    @Autowired
    IProductService productService;

    @PostMapping("")
    public Page<Product> saveCreate(@Valid @RequestBody Product product) {
        product.setStatus(true);
        productService.save(product);
        return productService.findAllByName("","", Pageable.unpaged());
    }

    @GetMapping("")
    public Page<Product> getList(@RequestParam (value = "name", defaultValue ="" )String name,
                                 @RequestParam (value = "manufacturer", defaultValue ="" )String manufacturer) {
        return productService.findAllByName(name,manufacturer,Pageable.unpaged());

    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Page<Product> deleteById(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        product.setStatus(false);
        productService.save(product);
        return getList("","");
    }
    @PatchMapping("")
    public Product saveEdit(@Valid @RequestBody Product product ){
        product.setStatus(true);
        productService.save(product);
        return product;
    }
}
