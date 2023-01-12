package com.springboot.learn.customer.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springboot.learn")
@EnableFeignClients(basePackages = "com.springboot.learn")
public class CustomerRun {
    public static void main(String[] args) {
        SpringApplication.run(CustomerRun.class,args);
    }
}
