package com.whitelist.mysql.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan(basePackages = "com.whitelist.mysql")
@MapperScan(basePackages = "com.whitelist.mysql.mapper")
@EnableAutoConfiguration
public class WhiteListRun {
    public static void main(String[] args) {
        SpringApplication.run(WhiteListRun.class,args);
    }
}
