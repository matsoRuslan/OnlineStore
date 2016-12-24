package com.test.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface BaseDao<T, Id> {
    Session openCurrentSession();

    Session openCurrentSessionwithTransaction();

    void closeCurrentSession();

    void closeCurrentSessionwithTransaction();

    Session getCurrentSession();

    void setCurrentSession(Session currentSession);

    Transaction getCurrentTransaction();

    void setCurrentTransaction(Transaction currentTransaction);

    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();

}
