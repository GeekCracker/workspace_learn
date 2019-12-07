package com.whitelist.mysql.controller;

import com.whitelist.mysql.response.ResponseResult;
import com.whitelist.mysql.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();

    public String index(){
        return "index";
    }

    @RequestMapping("listAll")
    public ResponseResult listAll(){
        return ResponseResult.ok(getService().listAll());
    }
}
