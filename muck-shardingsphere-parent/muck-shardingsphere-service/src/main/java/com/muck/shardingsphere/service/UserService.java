package com.muck.shardingsphere.service;

import com.muck.shardingsphere.domain.User;

public interface UserService extends BaseService<User>{

	public void save(User user);
}
