package com.springboot.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.springboot.learn")
@SpringBootConfiguration
@EnableAutoConfiguration
public class LearnDay20190803Run {

    public static void main(String[] args) {
        SpringApplication.run(LearnDay20190803Run.class,args);
    }
}
