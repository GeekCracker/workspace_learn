package com.springboot.learn.configuration;

import com.alibaba.fastjson.JSONObject;
import com.springboot.learn.domain.User;
import com.springboot.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfiguration extends BaseConfiguration<User>{

    @Autowired
    private UserService userService;

    @Override
    @KafkaListener(topics = "topic-01-test")
    public void receive(String message) {
        JSONObject json = (JSONObject) JSONObject.parse(message);
        //System.out.println(json.getClass().getTypeName());
        //CommodityIndexMonitor user = JSONObject.toJavaObject(json, CommodityIndexMonitor.class);
        User user = JSONObject.toJavaObject(json,User.class);
        userService.save(user);
    }
}
