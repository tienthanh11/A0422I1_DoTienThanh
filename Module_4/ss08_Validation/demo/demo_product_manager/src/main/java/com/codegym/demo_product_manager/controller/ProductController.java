package com.codegym.demo_product_manager.controller;

import com.codegym.demo_product_manager.model.Product;
import com.codegym.demo_product_manager.service.IProductService;
import com.codegym.demo_product_manager.service.IProductTypeService;
import com.codegym.demo_product_manager.validate.ValidateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    IProductTypeService productTypeService;

    @Autowired
    IProductService productService;

    @Autowired
    ValidateProduct validateProduct;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("listProduct", productService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProductType", productTypeService.findAll());
        return "product/create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute(value = "product") Product product, BindingResult bindingResult, Model model) {
        validateProduct.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listProductType", productTypeService.findAll());
            return "product/create";
        }
        productService.create(product);
        return "redirect:/list";
    }
}
