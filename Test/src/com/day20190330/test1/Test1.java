package com.day20190330.test1;

public class Test1 {

	public static void main(String[] args) {
		System.out.println(0b11);//��ӡ��������
		System.out.println(011);//��ӡ8������
		System.out.println(0x11);//��ӡ16������
		System.out.println((byte)130);
		
		Integer year = 2020;
		if(year % 3200 == 0) System.out.println(year + "��������");
		  else if(year % 400 == 0) System.out.println(year + "����");
		  else if(year % 100 == 0)System.out.println(year + "��������");
		  else if(year % 4 == 0) System.out.println(year + "������");
		  else System.out.println(year + "��������");
		
		System.out.println("\\\\\\");
		
	}
}
