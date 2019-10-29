package com.springboot.learn.jms.customer.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.springboot.learn.jms.customer"})
public class JMSCustomer001Run {

    public static void main(String[] args) {
        SpringApplication.run(JMSCustomer001Run.class,args);
    }
}
