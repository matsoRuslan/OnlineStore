package com.test.service.impl;

import com.test.dao.CartDao;
import com.test.entity.Cart;
import com.test.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends BaseServiceImpl<Cart, Long> implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public Cart findByUserId(Long id) {
        cartDao.openCurrentSession();
        Cart cart = cartDao.findByUserId(id);
        cartDao.closeCurrentSession();
        return cart;
    }
}
