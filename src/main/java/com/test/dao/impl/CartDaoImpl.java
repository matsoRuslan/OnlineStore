package com.test.dao.impl;

import com.test.dao.CartDao;
import com.test.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl extends BaseDaoImpl<Cart, Long> implements CartDao {
    @Override
    public Cart findById(Long id) {
        Cart cart = getCurrentSession().get(Cart.class, id);
        return cart;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cart> findAll() {
        List<Cart> carts = (List<Cart>) getCurrentSession().createQuery("from Cart").list();
        return carts;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Cart findByUserId(Long id) {
        Cart cart = (Cart) getCurrentSession().createQuery("from Cart where user_id = '" + id + "'").uniqueResult();
        return cart;
    }
}
