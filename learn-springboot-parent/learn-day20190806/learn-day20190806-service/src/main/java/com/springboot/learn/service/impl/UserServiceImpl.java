package com.springboot.learn.service.impl;

import com.springboot.learn.domain.User;
import com.springboot.learn.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public User queryById(String id,String seq) {
        User user = new User();
        user.setId(id);
        user.setUserName("张三"+id);
        user.setPassword("123456");
        user.setUserAge(12+"");
        Date date = new Date();
        user.setCreatedTime(date);
        user.setUpdatedTime(date);
        user.setSeq(seq);
        return user;
    }
}
