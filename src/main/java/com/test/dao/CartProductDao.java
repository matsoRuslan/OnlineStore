package com.test.dao;

import com.test.entity.CartProduct;

import java.util.List;

public interface CartProductDao extends BaseDao<CartProduct, Long> {
    List<CartProduct> findByProduct(Long id);
}
