package com.springboot.learn.admin.controller;

import com.springboot.learn.domain.User;
import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.BaseService;
import com.springboot.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController("AdminUserController")
@RequestMapping("/admin/user")
public class UserController extends BaseController<User>{

    @Autowired
    private UserService userService;

    @GetMapping("queryById/{id}")
    public ResponseResult queryById(@PathVariable("id") String id){
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://PROVIDER/admin/user/queryById/"+id,Object.class);

        return ResponseResult.ok(((LinkedHashMap<String,Object>)responseEntity.getBody()).get("data"));
    }


    @Override
    protected BaseService<User> getService() {
        return userService;
    }
}
