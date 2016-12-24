package com.test.dao;

import com.test.entity.Category;

public interface CategoryDao extends BaseDao<Category, Long> {
    Category findByTitle(String title);
}
