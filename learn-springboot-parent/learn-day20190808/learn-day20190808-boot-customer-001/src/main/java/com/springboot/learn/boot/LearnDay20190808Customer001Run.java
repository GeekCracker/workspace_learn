package com.springboot.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com.springboot.learn")
@EnableEurekaClient//启动Eureka客户端
@EnableHystrix//启动熔断器
public class LearnDay20190808Customer001Run {

    public static void main(String[] args) {
        SpringApplication.run(LearnDay20190808Customer001Run.class,args);
    }
}
