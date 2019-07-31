package com.day20190308.test1;

public class Test {

	public static void main(String[] args) {
		System.out.println(">>"+aa());
	}
	public static Integer aa(){
		try {
			System.out.println(1);
			return 2;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(3);
		}
		return 4;
	}
}
