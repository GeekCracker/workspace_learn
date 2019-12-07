package com.whitelist.mysql.domain;

import com.whitelist.mysql.annotation.Table;

import javax.validation.constraints.NotBlank;

@Table(name = "user")
public class User extends BaseEntity {

    /**授权的IP或域名*/
    @NotBlank(message = "IP不能为空")
    private String host;

    /**提供给授权host的登录用户名*/
    @NotBlank(message = "登录用户名不能为空")
    private String user;

    /**提供给授权host的登录密码*/
    @NotBlank(message = "登录密码不能为空")
    private String password;

    /**授权的操作，例如:insert,delete,update,update 不传默认为all*/
    private String operation;

    /**授权的数据库，不传默认为**/
    private String database;

    /**授权的表，不传默认为**/
    private String table;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
