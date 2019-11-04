package com.springboot.learn.rabbitmq.producer.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.springboot.learn.rabbitmq.producer"})
@EnableAutoConfiguration
public class ProducerRun {
    public static void main(String[] args) {
        SpringApplication.run(ProducerRun.class,args);
    }
}
