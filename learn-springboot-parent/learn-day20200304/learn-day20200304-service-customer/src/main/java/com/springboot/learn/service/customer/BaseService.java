package com.springboot.learn.service.customer;

import com.springboot.learn.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface BaseService<T> {

    @GetMapping(value = "/admin/user/queryById/{id}")
    ResponseResult queryById(@PathVariable("id") Long id);
}
