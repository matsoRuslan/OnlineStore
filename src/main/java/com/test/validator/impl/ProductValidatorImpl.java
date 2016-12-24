package com.test.validator.impl;

import com.test.entity.Product;
import com.test.service.CategoryService;
import com.test.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("productValidator")
public class ProductValidatorImpl implements ProductValidator {

    private static CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        ProductValidatorImpl.categoryService = categoryService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        ValidationUtils.rejectIfEmpty(errors, "title", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "description", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "fullDescription", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "price", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "amount", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "category.title", "notEmpty");

        if (!product.getCategory().getTitle().equals("") && categoryService.findByTitle(product.getCategory().getTitle()) == null) {
            errors.rejectValue("category.title", "categoryProduct");
        }
    }
}
