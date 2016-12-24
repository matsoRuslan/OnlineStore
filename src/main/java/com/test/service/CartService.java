package com.test.service;

import com.test.entity.Cart;

public interface CartService extends BaseService<Cart, Long> {
    Cart findByUserId(Long id);
}
