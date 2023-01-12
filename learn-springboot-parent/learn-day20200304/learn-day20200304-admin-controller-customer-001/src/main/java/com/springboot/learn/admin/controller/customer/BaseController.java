package com.springboot.learn.admin.controller.customer;

import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.customer.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class BaseController<T> {

    protected abstract BaseService<T>  getService();

    @RequestMapping("queryById/{id}")
    public ResponseResult queryById(@PathVariable("id") Long id){
        return getService().queryById(id);
    }
}
