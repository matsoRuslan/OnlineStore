package com.test.service;

import java.util.List;

public interface BaseService<T, Id> {
    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(Id id);

    List<T> findAll();

    void deleteAll();
}
