package com.test.dao.impl;

import com.test.dao.CategoryDao;
import com.test.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category, Long> implements CategoryDao {
    @Override
    public Category findById(Long id) {
        Category category = getCurrentSession().get(Category.class, id);
        return category;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        List<Category> categories = (List<Category>) getCurrentSession().createQuery("from Category").list();
        return categories;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Category findByTitle(String title) {
        Category category = (Category) getCurrentSession().createQuery("from Category where title = '" + title + "'").uniqueResult();
        return category;
    }
}
