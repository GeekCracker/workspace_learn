package com.springboot.learn.service.provider.impl;

import com.springboot.learn.domain.User;
import com.springboot.learn.service.provider.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setAge(20);
        user.setUsername("张三");
        user.setPhone("1235454545");
        user.setSex("男");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return user;
    }
}
