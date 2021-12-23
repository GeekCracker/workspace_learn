package com.springboot.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.learn.domain.User;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/producer/user")
public class UserController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("send")
    public void send(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        //kafkaTemplate.send("topic-01","hello world>>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        User user = new User();
                        user.setUsername("张三");
                        user.setSex("男");
                        user.setAge(12);
                        kafkaTemplate.send("data-center-topic-item-list", JSONObject.toJSONString(user));
                        System.out.println("send message ok!!");
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
