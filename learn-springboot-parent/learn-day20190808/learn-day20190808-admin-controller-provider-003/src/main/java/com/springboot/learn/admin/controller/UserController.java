package com.springboot.learn.admin.controller;

import com.springboot.learn.domain.User;
import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.BaseService;
import com.springboot.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminUserController")
@RequestMapping("/admin/user")
public class UserController extends BaseController<User>{

    @Autowired
    private UserService userService;

    @GetMapping("queryById/{id}")
    public ResponseResult queryById(@PathVariable("id") String id){
        //throw new RuntimeException("服务端测试异常！");
        return ResponseResult.ok(userService.queryById(id,"003"));
    }

    @Override
    protected BaseService<User> getService() {
        return userService;
    }
}
