package com.springboot.learn.rabbitmq.consumer.controller;

import com.springboot.learn.rabbitmq.domain.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class MessageController extends BaseController<Message> {


}
