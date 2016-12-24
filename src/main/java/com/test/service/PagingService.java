package com.test.service;

import com.test.entity.Product;

import java.util.List;

public interface PagingService {
    List<Product> findPaging(int page, int size);
}
