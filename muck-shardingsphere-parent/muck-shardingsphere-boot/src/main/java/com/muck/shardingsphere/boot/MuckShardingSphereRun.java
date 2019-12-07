package com.muck.shardingsphere.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com.muck")
@MapperScan("com.muck.shardingsphere.mapper")
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableScheduling
public class MuckShardingSphereRun {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MuckShardingSphereRun.class);
		application.run(args);
	}
}
