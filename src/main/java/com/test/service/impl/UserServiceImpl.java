package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserName(String userName) {
        userDao.openCurrentSession();
        User user = userDao.findByUserName(userName);
        userDao.closeCurrentSession();
        return user;
    }
}
