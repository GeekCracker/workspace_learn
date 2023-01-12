package com.springboot.learn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User extends BaseEntity{

    /**用户名*/
    private String username;

    /**用户密码*/
    private String password;

    /**用户性别*/
    private String sex;

    /**用户年龄*/
    private Integer age;

    /**联系方式*/
    private String phone;

    /**创建时间*/
    private Date createTime;

    /**最后修改时间*/
    private Date updateTime;
}
