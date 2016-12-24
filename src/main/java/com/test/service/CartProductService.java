package com.test.service;

import com.test.entity.CartProduct;

import java.util.List;

public interface CartProductService extends BaseService<CartProduct, Long> {
    List<CartProduct> findByProduct(Long id);
}
