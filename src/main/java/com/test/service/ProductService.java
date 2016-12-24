package com.test.service;

import com.test.entity.Product;

import java.util.List;

public interface ProductService extends BaseService<Product, Long> {
    List<Product> findByCategory(Long id);

    List<Product> findBySearchString(String searchString);
}
