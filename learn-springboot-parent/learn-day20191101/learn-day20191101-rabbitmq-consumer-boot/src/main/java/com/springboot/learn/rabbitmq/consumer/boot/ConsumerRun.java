package com.springboot.learn.rabbitmq.consumer.boot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.springboot.learn.rabbitmq.consumer"})
@EnableAutoConfiguration
@EnableRabbit
public class ConsumerRun {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRun.class,args);
    }
}
