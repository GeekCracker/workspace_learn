package com.day20190326.test1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test{

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true){
						System.out.println(sdf.format(calendar.getTime()));
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
