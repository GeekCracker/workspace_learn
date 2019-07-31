package com.day20190222.test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date start = sdf.parse("2019-02-22 17:00:00");
			Date end = sdf.parse("2019-02-22 18:00:00");
			System.out.println(start.getTime());
			System.out.println(end.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
