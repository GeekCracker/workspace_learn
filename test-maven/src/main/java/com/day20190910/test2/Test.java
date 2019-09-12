package com.day20190910.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
@Controller
public class Test {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
    }

    @RequestMapping("clientList")
    @ResponseBody
    public Object getClients(){
        return stringRedisTemplate.getClientList();
    }
    @RequestMapping("killClient")
    @ResponseBody
    public Object killClient(){
        List<RedisClientInfo> clientInfoStatusList = stringRedisTemplate.getClientList();
        for(RedisClientInfo redisClientInfo : clientInfoStatusList){
            String addressPort = redisClientInfo.getAddressPort();
            String [] str = addressPort.split(":");
            System.out.println(addressPort);
            stringRedisTemplate.killClient(str[0],Integer.parseInt(str[1]));
        }
        return "OK";
    }


    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        //设置链接工厂类配置信息
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }
}
