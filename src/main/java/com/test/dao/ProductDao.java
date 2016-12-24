package com.test.dao;

import com.test.entity.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product, Long> {
    List<Product> findByCategory(Long id);

    List<Product> findBySearchString(String searchString);
}
