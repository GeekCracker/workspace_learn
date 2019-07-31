package com.day20190306.test1;

import java.net.URLPermission;

public class Test {

	public static void main(String[] args) {
		String str = "http://192.168.1.12/static/image/111.png";
		System.out.println(str.indexOf("//")+2);
		System.out.println(str.charAt(str.indexOf("//")+2));
		System.out.println(str.indexOf("/",str.indexOf("//")+2));
		System.out.println(str.charAt(str.indexOf("/",str.indexOf("//")+2)));
		System.out.println(str.substring(str.indexOf("/",str.indexOf("//")+2)));
		URLPermission permission = new URLPermission(str);
		System.out.println("name:"+permission.getName());
	}
}
