package com.spring.domain;

public class User {

	private String userName;
	
	private String userSex;
	
	private Integer userAge;

	public User() {
		System.out.println("实例化了User类");
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
		return "User [userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge + "]";
	}
}
