package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

    @Override
    public User findById(Long id) {
        User user = getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        List<User> users = (List<User>) getCurrentSession().createQuery("from User").list();
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findByUserName(String userName) {
        User user = (User) getCurrentSession().createQuery("from User where userName = '" + userName + "'").uniqueResult();
        return user;
    }
}
