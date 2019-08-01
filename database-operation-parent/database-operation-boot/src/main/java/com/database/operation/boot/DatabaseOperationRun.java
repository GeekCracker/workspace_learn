package com.database.operation.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = {"com.database.operation"})
@MapperScan(basePackages = {"com.database.operation.mapper"})
@EnableAutoConfiguration
@PropertySource(value = {"config.properties"})
public class DatabaseOperationRun {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseOperationRun.class,args);
    }

}
