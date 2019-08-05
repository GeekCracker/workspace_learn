package com.springboot.learn.service;

public interface BaseService<T> {

    public T queryById(String id);
}
