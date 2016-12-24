package com.test.service.impl;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findByCategory(Long id) {
        productDao.openCurrentSession();
        List<Product> products = productDao.findByCategory(id);
        productDao.closeCurrentSession();
        return products;
    }

    @Override
    public List<Product> findBySearchString(String searchString) {
        productDao.openCurrentSession();
        List<Product> products = productDao.findBySearchString(searchString);
        productDao.closeCurrentSession();
        return products;
    }
}
