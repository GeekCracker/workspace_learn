package com.springboot.learn.admin.controller.provider;

import com.springboot.learn.domain.User;
import com.springboot.learn.service.provider.BaseService;
import com.springboot.learn.service.provider.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController<User>{

    @Autowired
    private UserService userService;

    @Override
    protected BaseService<User> getService() {
        return userService;
    }
}
