package com.springboot.learn.jms.customer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class MessageListener {

    @Autowired
    JmsTemplate jmsTemplate;
    public static void test1(){
    }
}
