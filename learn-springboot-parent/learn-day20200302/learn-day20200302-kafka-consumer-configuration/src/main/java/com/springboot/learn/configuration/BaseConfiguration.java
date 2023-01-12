package com.springboot.learn.configuration;

import com.springboot.learn.domain.BaseEntity;

/**
 * @description:
 * @author: 朱俊亮
 * @time: 2020/3/20 9:21
 */
public abstract class BaseConfiguration<T extends BaseEntity> {

    public abstract void receive(String message);
}
