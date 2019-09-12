package com.spring.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value={"beansFieldValue.properties"})
public class Person {

	@Value("${person.name}")
	private String userName;
	
	@Value("${person.sex}")
	private String userSex;
	
	@Value("${person.age}")
	private Integer userAge;
	
	public Person() {
		System.out.println("实例化了Person类");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge + "]";
	}
}
