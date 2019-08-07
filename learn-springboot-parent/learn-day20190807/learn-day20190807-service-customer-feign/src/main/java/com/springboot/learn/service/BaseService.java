package com.springboot.learn.service;

import org.springframework.http.ResponseEntity;

public interface BaseService<T> {

    ResponseEntity<Object> queryById(String id);
}
