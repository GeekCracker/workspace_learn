package com.springboot.learn.rabbitmq.producer.service;

import com.springboot.learn.rabbitmq.domain.Message;

public interface MessageService extends BaseService<Message> {

    /**
     * 发送消息
     * @param message 传入一个消息体
     */
    public void sendMessage(Message message);
}
