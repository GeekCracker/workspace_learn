package com.springboot.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springboot.learn")
@EnableFeignClients(basePackages = "com.springboot.learn")
@EnableKafka
public class KafkaConsumerRun {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerRun.class,args);
    }
}
