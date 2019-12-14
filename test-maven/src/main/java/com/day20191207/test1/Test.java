package com.day20191207.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@EnableAutoConfiguration
@RestController
@ComponentScan(basePackages = {"com.day20191207.test1"})
public class Test {

    @Autowired
    RedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
    }

    @RequestMapping("get")
    public Object get(String key){
        return redisTemplate.opsForHash().get("labelTree",key);
    }

    @RequestMapping("put")
    public Object put(String key){
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("name","ÕÅÈý");
        map.put("age",20);
        redisTemplate.opsForHash().put("labelTree",key,map);
        return true;
    }
}
