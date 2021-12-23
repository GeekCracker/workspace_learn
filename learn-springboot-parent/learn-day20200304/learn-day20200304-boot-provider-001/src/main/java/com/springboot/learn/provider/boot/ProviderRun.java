package com.springboot.learn.provider.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springboot.learn")
public class ProviderRun {

    public static void main(String[] args) {
        SpringApplication.run(ProviderRun.class,args);
    }
}
