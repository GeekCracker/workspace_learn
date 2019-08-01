package com.springboot.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.springboot.learn")
@EnableAutoConfiguration
@SpringBootConfiguration
public class BootRun {
    public static void main(String[] args) {
        SpringApplication.run(BootRun.class,args);
    }
}