package com.day20190916.test1;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.day20190916.test1")
public class MyConfig {


    @Bean(autowire = Autowire.BY_NAME)
    public Bean1 bean1(){
        return new Bean1();
    }

    @Bean(autowire = Autowire.BY_NAME)
    public Bean2 bean2(){
        return new Bean2();
    }
}
