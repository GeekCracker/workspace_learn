package com.springboot.learn.service;

public interface BaseService<T> {

    T queryById(String id,String seq);
}
