package com.muck.shardingsphere.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import com.muck.shardingsphere.domain.User;

@Mapper
public interface UserMapper {

	@Insert("insert into t_user(username,age) values(#{user.username},#{user.age});")
	@SelectKey(before=false,keyColumn="id",keyProperty="id",statement="SELECT LAST_INSERT_ID()",resultType=Long.class)
	public void save(@Param("user")User user);
}
