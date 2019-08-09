package com.springboot.learn.boot;

import feign.Feign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com.springboot.learn")
@EnableEurekaClient//启动Eureka客户端
@EnableFeignClients(basePackages = "com.springboot.learn")//启动Feign客户端，主要扫描@FeignClient注解标注的java文件
//Feign默认是启动了Hystrix所以不用手动启动
public class LearnDay20190808Customer002Run {
    public static void main(String[] args) {
        SpringApplication.run(LearnDay20190808Customer002Run.class,args);
    }
}

@Configuration
class FooConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
