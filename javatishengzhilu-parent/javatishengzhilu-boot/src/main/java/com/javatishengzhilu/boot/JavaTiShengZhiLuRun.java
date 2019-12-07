package com.javatishengzhilu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.javatishengzhilu"})
@EnableAutoConfiguration
public class JavaTiShengZhiLuRun {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(JavaTiShengZhiLuRun.class);
        application.run(args);
    }
}
