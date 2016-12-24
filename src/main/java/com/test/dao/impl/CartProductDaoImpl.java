package com.test.dao.impl;

import com.test.dao.CartProductDao;
import com.test.entity.CartProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartProductDaoImpl extends BaseDaoImpl<CartProduct, Long> implements CartProductDao {
    @Override
    public CartProduct findById(Long id) {
        CartProduct cartProduct = getCurrentSession().get(CartProduct.class, id);
        return cartProduct;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CartProduct> findAll() {
        List<CartProduct> cartProducts = (List<CartProduct>) getCurrentSession().createQuery("from CartProduct").list();
        return cartProducts;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CartProduct> findByProduct(Long id) {
        List<CartProduct> cartProducts = (List<CartProduct>) getCurrentSession().createQuery("from CartProduct where product_id = '" + id + "'").list();
        return cartProducts;
    }
}
