package com.day20190306.test2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "�ļ������ļ�����";
		String i = URLEncoder.encode(str,"UTF-8");
		System.out.println(i);
	}
}
