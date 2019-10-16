package com.day20190913.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Test.class);
        springApplication.getSources().add("111");
        //springApplication.addInitializers(new MyInitializer());
        springApplication.run(args);
    }
}
