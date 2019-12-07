package com.muck.shardingsphere.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muck.shardingsphere.domain.User;
import com.muck.shardingsphere.service.UserService;

@RestController("AdminUserController")
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("save.action")
	public Map<String,Object> save(User user){
		userService.save(user);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "200");
		map.put("data", user);
		map.put("msg", "操作成功");
		return map;
	}
}
