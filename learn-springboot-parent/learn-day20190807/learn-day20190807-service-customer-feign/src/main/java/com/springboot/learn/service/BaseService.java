package com.springboot.learn.service;

import com.springboot.learn.response.ResponseResult;

public interface BaseService<T> {

    ResponseResult queryById(String id);
}
