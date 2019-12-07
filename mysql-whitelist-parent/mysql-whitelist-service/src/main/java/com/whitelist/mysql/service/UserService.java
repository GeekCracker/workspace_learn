package com.whitelist.mysql.service;

import com.whitelist.mysql.domain.User;

public interface UserService extends BaseService<User> {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param user
     */
    void deleteUser(User user);

    /**
     * 授权操作
     * @param user
     */
    void grant(User user);

    /**
     * 撤销授权操作
     * @param user
     */
    void revoke(User user);

    /**
     * 修改密码
     * @param user
     */
    void updatePassword(User user);
}
