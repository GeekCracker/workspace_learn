package com.springboot.learn.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

    /**主键ID*/
    private Long id;
}
