package com.springboot.learn.rabbitmq.consumer.service;

import com.springboot.learn.rabbitmq.domain.Message;

public interface MessageService extends BaseService<Message> {
    public void acceptMessage(Message message);
}
