package com.test.service;

import com.test.entity.User;

public interface UserService extends BaseService<User, Long>{
    User findByUserName(String userName);
}
