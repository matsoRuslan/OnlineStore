package com.test.controller;

import com.test.entity.Category;
import com.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class CategoryController {
    private static CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        CategoryController.categoryService = categoryService;
    }

    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<Category>> listAllCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
