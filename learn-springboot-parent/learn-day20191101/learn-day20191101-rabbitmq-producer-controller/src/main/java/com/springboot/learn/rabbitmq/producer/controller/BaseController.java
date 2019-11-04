package com.springboot.learn.rabbitmq.producer.controller;

import com.springboot.learn.rabbitmq.producer.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();
}
