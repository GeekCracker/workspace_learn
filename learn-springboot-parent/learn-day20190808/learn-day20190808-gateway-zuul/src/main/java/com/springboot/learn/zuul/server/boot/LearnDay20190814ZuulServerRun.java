package com.springboot.learn.zuul.server.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.springboot.learn")
@SpringBootConfiguration
@EnableAutoConfiguration
@EnableZuulProxy
public class LearnDay20190814ZuulServerRun {

    public static void main(String[] args) {
        SpringApplication.run(LearnDay20190814ZuulServerRun.class,args);
    }
}
