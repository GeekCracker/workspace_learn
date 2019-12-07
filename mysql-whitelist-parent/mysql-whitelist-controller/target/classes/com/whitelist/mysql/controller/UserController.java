package com.whitelist.mysql.controller;

import com.whitelist.mysql.domain.User;
import com.whitelist.mysql.form.UserQueryForm;
import com.whitelist.mysql.helper.QueryHelper;
import com.whitelist.mysql.response.ResponseResult;
import com.whitelist.mysql.service.BaseService;
import com.whitelist.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("UserController")
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    public ResponseResult addUser(@Valid User user){
        userService.addUser(user);
        return ResponseResult.ok();
    }

    @RequestMapping("deleteUser")
    public ResponseResult deleteUser(@Valid User user){
        userService.deleteUser(user);
        return ResponseResult.ok();
    }

    @RequestMapping("updatePassword")
    public ResponseResult updatePassword(@Valid User user){
        userService.updatePassword(user);
        return ResponseResult.ok();
    }

    @PostMapping("grant")
    public ResponseResult grant(@Valid User user){
        userService.grant(user);
        return ResponseResult.ok();
    }

    @PostMapping("revoke")
    public ResponseResult revoke(@Valid User user){
        userService.revoke(user);
        return ResponseResult.ok();
    }

    @RequestMapping("queryData")
    public ResponseResult queryData(UserQueryForm form){
        QueryHelper queryHelper = new QueryHelper();
        return ResponseResult.ok(userService.queryData(queryHelper.getWhereSQL(),queryHelper.getWhereParams()));
    }

    @Override
    protected BaseService<User> getService() {
        return userService;
    }
}
