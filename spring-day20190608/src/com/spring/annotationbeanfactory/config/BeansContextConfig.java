package com.spring.annotationbeanfactory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.spring.domain.User;

@Configuration
@ComponentScan(basePackages={"com.spring.domain",
		"com.spring.postprocessor",
		"com.spring.listener"})
public class BeansContextConfig {

	/**
	 * ?????????????????????е??????
	 * @return ??????????
	 */
	@Bean
	@Conditional(value=MyConditional.class)
	public User user(){
		User user = new User();
		user.setUserName("????");
		user.setUserSex("??");
		user.setUserAge(25);
		return user;
	}
}
