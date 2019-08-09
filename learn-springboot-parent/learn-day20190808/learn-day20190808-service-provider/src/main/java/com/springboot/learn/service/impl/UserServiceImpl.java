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
        //TODO 在服务端这里制造一个异常，用来测试客户端调用时的熔断效果
        /*int i = 0;
        i = 1/i;*/
        return user;
    }
}
