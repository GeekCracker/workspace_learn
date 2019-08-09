package com.springboot.learn.admin.controller;


import com.springboot.learn.service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminBaseController")
@RequestMapping("/")
public abstract class BaseController<T> {
    protected abstract BaseService<T> getService();
}





