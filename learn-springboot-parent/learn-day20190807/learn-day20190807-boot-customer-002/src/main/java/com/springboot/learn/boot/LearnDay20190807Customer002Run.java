package com.springboot.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.springboot.learn")
@EnableEurekaClient//启动Eureka客户端
@EnableFeignClients(basePackages = {"com.springboot.learn"})//启动Feign客户端，主要扫描@FeignClient注解标注的java文件
//Feign默认是启动了Hystrix所以不用手动启动
public class LearnDay20190807Customer002Run {
    public static void main(String[] args) {
        SpringApplication.run(LearnDay20190807Customer002Run.class,args);
    }
}


