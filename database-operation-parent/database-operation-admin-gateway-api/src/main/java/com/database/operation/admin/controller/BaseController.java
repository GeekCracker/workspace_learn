package com.database.operation.admin.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.database.operation.response.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public abstract class BaseController<T>{

    /**
     * 获取当前service
     * @return 返回当前service
     */
    protected abstract IService<T> getService();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("save")
    public ResponseResult save(T t){
        getService().save(t);
        return  ResponseResult.ok();
    }
}
