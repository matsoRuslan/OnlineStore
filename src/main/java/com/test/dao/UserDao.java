package com.test.dao;

import com.test.entity.User;

public interface UserDao extends BaseDao<User, Long> {
    User findByUserName(String userName);
}
