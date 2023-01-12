package com.springboot.learn.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 实体类基类
 */
@Data
public class BaseEntity implements Serializable {

    private Long id;
}
