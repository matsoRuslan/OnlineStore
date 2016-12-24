package com.test.dao.impl;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product, Long> implements ProductDao {
    @Override
    public Product findById(Long id) {
        Product product = getCurrentSession().get(Product.class, id);
        return product;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product").list();
        return products;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findByCategory(Long id) {
        List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product where category_id = '" + id + "'").list();
        return products;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findBySearchString(String searchString) {
        searchString = "%" + searchString + "%";
        List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product where title like '" + searchString + "'").list();
        return products;
    }
}
