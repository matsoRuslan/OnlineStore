package com.test.service.impl;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.service.PagingService;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagingServiceImpl implements PagingService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findPaging(int page, int size) {
        productDao.openCurrentSession();
        Query query = productDao.getCurrentSession().createQuery("from Product");
        query.setFirstResult(page);
        query.setMaxResults(size);
        List<Product> products = (List<Product>) query.list();
        productDao.closeCurrentSession();
        return products;
    }
}
