package com.codegym.example1.controller;

import com.codegym.example1.service.ICategoryService;
import com.codegym.example1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String goHome(Model model,
                         @RequestParam(value = "name", defaultValue = "") String name,
                         @RequestParam(value = "manufacturer", defaultValue = "") String manufacturer,
                         @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("name", name);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("productList", productService.findAllByName(name, manufacturer, pageable));
        model.addAttribute("categoryList", categoryService.findAll());
        return "home";
    }
}
