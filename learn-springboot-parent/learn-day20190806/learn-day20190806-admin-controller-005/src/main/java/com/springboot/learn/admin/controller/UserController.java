package com.springboot.learn.admin.controller;

import com.springboot.learn.domain.User;
import com.springboot.learn.service.BaseService;
import com.springboot.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminUserController")
@RequestMapping("/admin/user")
public class UserController extends BaseController<User>{

    @Autowired
    private UserService userService;


    @Override
    protected BaseService<User> getService() {
       return userService;
    }
}
