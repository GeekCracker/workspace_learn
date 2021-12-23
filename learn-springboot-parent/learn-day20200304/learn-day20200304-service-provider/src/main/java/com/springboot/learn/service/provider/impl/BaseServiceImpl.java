package com.springboot.learn.service.provider.impl;

import com.springboot.learn.service.provider.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Override
    public T queryById(Long id) {
        return null;
    }
}
