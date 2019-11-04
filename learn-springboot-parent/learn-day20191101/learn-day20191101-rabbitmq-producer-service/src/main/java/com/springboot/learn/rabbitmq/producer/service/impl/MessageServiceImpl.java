package com.springboot.learn.rabbitmq.producer.service.impl;

import com.springboot.learn.rabbitmq.domain.Message;
import com.springboot.learn.rabbitmq.producer.service.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(Message message){
        rabbitTemplate.convertAndSend("jiaohuanji001","learn-queue-day20191101",message);
    }
}
