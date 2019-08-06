package com.springboot.learn.admin.controller;


import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;

@Controller("AdminBaseController")
@RequestMapping("/")
public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();

    @RequestMapping("queryById/{id}")
    public ResponseResult queryById(@PathVariable("id") String id){
        return ResponseResult.ok(((LinkedHashMap<String,Object>)getService().queryById(id).getBody()).get("data"));
    }
}





