package com.springboot.learn.rabbitmq.consumer.service.impl;

import com.springboot.learn.rabbitmq.consumer.service.MessageService;
import com.springboot.learn.rabbitmq.domain.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"learn-queue-day20191101"})
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

    @RabbitHandler
    @Override
    public void acceptMessage(Message message) {
        System.out.println(message);
    }

}
