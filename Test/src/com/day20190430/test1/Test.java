package com.day20190430.test1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) throws Exception{
		String str = "http://localhost:8080/admin/queryById.action?name=\u0000����\u0001";
		System.out.println(str);
		
		Boolean flag = Pattern.matches("[\u0000]", str);
		System.out.println(flag);
		//str = str.replaceAll("[\u0000-\u9999\u4e00-\u9fa5]","");
		Pattern pattern = Pattern.compile("[\u0000\u0001]");
		Matcher matcher = pattern.matcher(str);
		System.out.println("�Ƿ����ƥ�䵽:"+matcher.find());//�Ƿ����ƥ�䵽
		System.out.println("start:"+matcher.start() + ">>>end:"+matcher.end());
		System.out.println(matcher.group());
		System.out.println(matcher.groupCount());
		
		System.out.println("�滻��Ľ��:"+matcher.replaceAll(""));
	}
}
