package com.springboot.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springboot.learn")
@EnableKafka
public class KafkaProducerRun {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerRun.class,args);
    }
}
