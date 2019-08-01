package com.springboot.learn.service.impl;

import com.springboot.learn.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Override
    public T queryById(String id) {
        return null;
    }
}
