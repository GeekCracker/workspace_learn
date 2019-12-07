package com.whitelist.mysql.service.impl;

import com.whitelist.mysql.domain.User;
import com.whitelist.mysql.mapper.BaseMapper;
import com.whitelist.mysql.mapper.UserMapper;
import com.whitelist.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.useDatabase("mysql");
        userMapper.addUser(user);
        userMapper.flushPrivileges();
    }

    @Override
    public void deleteUser(User user){
        userMapper.useDatabase("mysql");
        userMapper.deleteUser(user);
        userMapper.flushPrivileges();
    }
    @Override
    public void grant(User user) {
        userMapper.useDatabase("mysql");
        userMapper.grant(user);
        userMapper.flushPrivileges();
    }

    @Override
    public void revoke(User user) {
        userMapper.useDatabase("mysql");
        userMapper.revoke(user);
        userMapper.flushPrivileges();
    }

    @Override
    public void updatePassword(User user) {
        userMapper.useDatabase("mysql");
        userMapper.updatePassword(user);
        userMapper.flushPrivileges();
    }

    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    protected String getFields() {
        return "host,user";
    }
}
