package com.test.dao.impl;

import com.test.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseDaoImpl<T, Id> implements BaseDao<T, Id> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession;

    private Transaction currentTransaction;

    @Override
    public Session openCurrentSession() {
        currentSession = sessionFactory.openSession();
        return currentSession;
    }

    @Override
    public Session openCurrentSessionwithTransaction() {
        currentSession = sessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    @Override
    public void closeCurrentSession() {
        currentSession.close();
    }

    @Override
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    @Override
    public Session getCurrentSession() {
        return currentSession;
    }

    @Override
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    @Override
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    @Override
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(T entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }


    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }


    @Override
    public void deleteAll() {
        List<T> entityList = findAll();
        for (T entity : entityList) {
            delete(entity);
        }
    }

}
