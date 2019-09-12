package com.day20190910.test1;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class Test {
    @Autowired
    Redisson redisson;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Test.class);
        springApplication.run(args);
    }

    @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useClusterServers().addNodeAddress("redis://192.168.191.2:7001","redis://192.168.191.2:7002","redis://192.168.191.2:7003","redis://192.168.191.2:7004","redis://192.168.191.2:7005","redis://192.168.191.2:7006");
        Redisson redisson = (Redisson) Redisson.create(config);
        return redisson;
    }

    @RequestMapping("read")
    @ResponseBody
    public Object read(String key){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("value",redisson.getBucket(key));
        map.put("nodes",redisson.getClusterNodesGroup().getNodes());
        return map;
    }

    @RequestMapping("write")
    @ResponseBody
    public Object write(String key,String value){
        redisson.getBucket(key).set(value);
        return "OK";
    }
}
