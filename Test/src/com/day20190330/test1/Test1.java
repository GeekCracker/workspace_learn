package com.day20190330.test1;

public class Test1 {

	public static void main(String[] args) {
		System.out.println(0b11);//打印二进制数
		System.out.println(011);//打印8进制数
		System.out.println(0x11);//打印16进制数
		System.out.println((byte)130);
		
		Integer year = 2020;
		if(year % 3200 == 0) System.out.println(year + "不是闰年");
		  else if(year % 400 == 0) System.out.println(year + "闰年");
		  else if(year % 100 == 0)System.out.println(year + "不是闰年");
		  else if(year % 4 == 0) System.out.println(year + "是闰年");
		  else System.out.println(year + "不是闰年");
		
		System.out.println("\\\\\\");
		
	}
}
