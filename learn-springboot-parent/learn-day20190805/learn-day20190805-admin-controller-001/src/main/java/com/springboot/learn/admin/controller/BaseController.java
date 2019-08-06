package com.springboot.learn.admin.controller;


import com.springboot.learn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller("AdminBaseController")
@RequestMapping("/")
public abstract class BaseController<T> {

    @Autowired
    protected RestTemplate restTemplate;

    protected abstract BaseService<T> getService();

}





