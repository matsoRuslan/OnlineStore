package com.test.validator.impl;

import com.test.entity.Category;
import com.test.service.CategoryService;
import com.test.validator.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("categoryValidator")
public class CategoryValidatorImpl implements CategoryValidator {
    private static CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        CategoryValidatorImpl.categoryService = categoryService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Category.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Category category = (Category) o;
        ValidationUtils.rejectIfEmpty(errors, "title", "notEmpty");

        if (!category.getParent().getTitle().equals("") && categoryService.findByTitle(category.getParent().getTitle()) == null) {
            errors.rejectValue("parent.title", "categoryParent");
        }
    }
}
