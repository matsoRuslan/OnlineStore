package com.test.service.impl;

import com.test.dao.BaseDao;
import com.test.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseServiceImpl<T, Id> implements BaseService<T, Id> {
    @Autowired
    private BaseDao<T, Id> baseDao;

    @Override
    public void persist(T entity) {
        baseDao.openCurrentSessionwithTransaction();
        baseDao.persist(entity);
        baseDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(T entity) {
        baseDao.openCurrentSessionwithTransaction();
        baseDao.update(entity);
        baseDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public T findById(Id id) {
        baseDao.openCurrentSession();
        T entity = baseDao.findById(id);
        baseDao.closeCurrentSession();
        return entity;
    }

    @Override
    public void delete(Id id) {
        baseDao.openCurrentSessionwithTransaction();
        T entity = baseDao.findById(id);
        baseDao.delete(entity);
        baseDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<T> findAll() {
        baseDao.openCurrentSession();
        List<T> entities = baseDao.findAll();
        baseDao.closeCurrentSession();
        return entities;
    }

    @Override
    public void deleteAll() {
        baseDao.openCurrentSessionwithTransaction();
        baseDao.deleteAll();
        baseDao.closeCurrentSessionwithTransaction();
    }
}
