package com.springboot.learn.admin.controller;


import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;

@Controller("AdminBaseController")
@RequestMapping("/")
public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();

    @GetMapping("queryById/{id}")
    public ResponseResult queryById(@PathVariable("id") String id){

        return ResponseResult.ok(getService().queryById(id).getdata());
        //return ResponseResult.ok(((LinkedHashMap<String,Object>)getService().queryById(id).getBody()).get("data"));
    }
}





