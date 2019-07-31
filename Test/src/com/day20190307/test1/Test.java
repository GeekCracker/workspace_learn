package com.day20190307.test1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
		String formatDate = sdf.format(date);
		System.out.println(formatDate.substring(0,formatDate.length()));
	}
}
