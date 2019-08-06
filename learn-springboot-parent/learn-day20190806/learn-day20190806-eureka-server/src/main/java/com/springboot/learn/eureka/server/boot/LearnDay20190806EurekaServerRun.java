package com.springboot.learn.eureka.server.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springboot.learn.eureka")
@Configuration
@EnableEurekaServer
public class LearnDay20190806EurekaServerRun {

    public static void main(String[] args) {
        SpringApplication.run(LearnDay20190806EurekaServerRun.class,args);
    }
}
