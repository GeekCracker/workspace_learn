package com.springboot.learn.rabbitmq.producer.controller;

import com.springboot.learn.rabbitmq.domain.Message;
import com.springboot.learn.rabbitmq.response.ResponseResult;
import com.springboot.learn.rabbitmq.producer.service.BaseService;
import com.springboot.learn.rabbitmq.producer.service.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController("MessageController")
@RequestMapping("/admin/message")
public class MessageController extends BaseController<Message> {

    @Autowired
    private MessageService messageService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("sendMessage")
    public ResponseResult sendMessage(Message message){
        messageService.sendMessage(message);
        return ResponseResult.success();
    }


    @Override
    protected BaseService<Message> getService() {
        return messageService;
    }
}
