package com.springboot.learn.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 实体类基类
 * @author: 朱俊亮
 * @time: 2021-12-23 11:20
 */
@Data
public class BaseEntity implements Serializable {

    /**主键ID*/
    private Long id;
}
