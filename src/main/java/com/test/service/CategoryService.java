package com.test.service;

import com.test.entity.Category;

public interface CategoryService extends BaseService<Category, Long> {
    Category findByTitle(String title);
}
