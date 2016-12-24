package com.test.service.impl;

import com.test.dao.CategoryDao;
import com.test.entity.Category;
import com.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category findByTitle(String title) {
        categoryDao.openCurrentSession();
        Category category = categoryDao.findByTitle(title);
        categoryDao.closeCurrentSession();
        return category;
    }
}
