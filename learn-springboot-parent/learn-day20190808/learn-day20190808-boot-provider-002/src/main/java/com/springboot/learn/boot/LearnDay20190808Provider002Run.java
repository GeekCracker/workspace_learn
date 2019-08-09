package com.springboot.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springboot.learn")
@EnableAutoConfiguration
@EnableEurekaClient
public class LearnDay20190808Provider002Run {

    public static void main(String[] args) {
        SpringApplication.run(LearnDay20190808Provider002Run.class,args);
    }
}
