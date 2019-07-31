package com.day20190318.test1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws Exception{
		String str = "2019-01-09";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		System.out.println(String.format("%tF 00:00:00", date));;
		System.out.println(String.format("%tF",new Date()));
		System.out.println(String.format("%tT",new Date()));
	}
}
