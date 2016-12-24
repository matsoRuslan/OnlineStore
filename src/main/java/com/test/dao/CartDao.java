package com.test.dao;

import com.test.entity.Cart;

public interface CartDao extends BaseDao<Cart, Long> {
    Cart findByUserId(Long id);
}
