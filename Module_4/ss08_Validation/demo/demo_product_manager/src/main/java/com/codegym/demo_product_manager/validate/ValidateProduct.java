package com.codegym.demo_product_manager.validate;

import com.codegym.demo_product_manager.model.Product;
import com.codegym.demo_product_manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class ValidateProduct implements Validator {

    @Autowired
    IProductService productService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        Date date = new Date();
        if(date.before(product.getDatePublish())) {
            errors.rejectValue("datePublish", "DateValidate", null, "Ngày bạn không được lớn hơn ngày hiện tại");
        }
        if(productService.findByName(product.getName()).size() != 0) {
            errors.rejectValue("name", "nameValidate", null, "Tên không được trùng");
        }
    }
}
