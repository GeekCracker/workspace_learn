package com.springboot.learn.service.provider;

public interface BaseService<T> {

    T queryById(Long id);
}
