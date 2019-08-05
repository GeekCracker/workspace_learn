package com.springboot.learn.admin.controller;

import com.springboot.learn.form.UserQueryForm;
import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController("AdminBaseController")
@RequestMapping("/")
@Validated
public abstract class BaseController<T> {

    /**
     * 获取当前service
     * @return 返回当前service
     */
    protected abstract BaseService<T> getService();

    @GetMapping("queryById")
    public ResponseResult queryById(@Valid UserQueryForm userQueryForm){
        return ResponseResult.ok(getService().queryById(userQueryForm.getEmail()));
    }
}
