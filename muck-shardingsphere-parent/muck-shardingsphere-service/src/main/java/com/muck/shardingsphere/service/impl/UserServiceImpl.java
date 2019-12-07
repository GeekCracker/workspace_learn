package com.muck.shardingsphere.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muck.shardingsphere.domain.User;
import com.muck.shardingsphere.mapper.UserMapper;
import com.muck.shardingsphere.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public void save(User user) {
		userMapper.save(user);
	}
}
