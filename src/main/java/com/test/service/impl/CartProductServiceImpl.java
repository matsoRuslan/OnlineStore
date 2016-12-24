package com.test.service.impl;

import com.test.dao.CartProductDao;
import com.test.entity.CartProduct;
import com.test.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductServiceImpl extends BaseServiceImpl<CartProduct, Long> implements CartProductService {
    @Autowired
    private CartProductDao cartProductDao;

    @Override
    public void delete(Long id) {
        cartProductDao.openCurrentSessionwithTransaction();
        cartProductDao.getCurrentSession().createSQLQuery("delete from cart_cartproduct where cartProducts_id = " + id).executeUpdate();
        cartProductDao.getCurrentSession().createSQLQuery("delete from cartproduct where id = " + id).executeUpdate();
        cartProductDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<CartProduct> findByProduct(Long id) {
        cartProductDao.openCurrentSession();
        List<CartProduct> cartProducts = cartProductDao.findByProduct(id);
        cartProductDao.closeCurrentSession();
        return cartProducts;
    }
}
