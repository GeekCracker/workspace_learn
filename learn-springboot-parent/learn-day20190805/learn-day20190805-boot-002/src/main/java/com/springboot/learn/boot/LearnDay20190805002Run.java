package com.springboot.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com.springboot.learn")
@EnableEurekaClient
public class LearnDay20190805002Run {

    public static void main(String[] args) {
        SpringApplication.run(LearnDay20190805002Run.class,args);
    }
}
