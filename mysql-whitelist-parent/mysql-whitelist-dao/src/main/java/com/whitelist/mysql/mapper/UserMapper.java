package com.whitelist.mysql.mapper;

import com.whitelist.mysql.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserMapper extends BaseMapper<User> {

    @Update("create user '${user.user}'@'${user.host}' identified by '${user.password}';")
    void addUser(@Param("user") User user);

    @Update("drop user '${user.user}'@'${user.host}';")
    void deleteUser(@Param("user") User user);

    @Update("grant ${user.operation} on ${user.database}.${user.table} to '${user.user}'@'${user.host}' identified by '${user.password}';")
    void grant(@Param("user") User user);

    @Update("revoke ${user.operation} on ${user.database}.${user.table} from '${user.user}'@'${user.host}';")
    void revoke(@Param("user") User user);

    @Update("update mysql.user set authentication_string=password('${user.password}') where user='${user.user}' and Host = '${user.host}';")
    void updatePassword(@Param("user") User user);
}
