package com.redis.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.redis"})
@MapperScan(basePackages = {"com.redis.mapper"})
@EnableAutoConfiguration
public class RedisRun {

    public static void main(String[] args) {
        SpringApplication.run(RedisRun.class,args);
    }
}
