package com.day20190329.test1;

import java.net.URL;

public class Test {

	public static void main(String[] args){
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true){
						System.out.println("开始请求");
						String url = "http://localhost:9989/xoffice/xoffice?_key=false&_xformat=xls&_format=html&_file=";
						url += "http://localhost:7766/static/image/upload/2019/03/13/21/1a2d176285ba4057b6bfd2d4c7e47f1b/管理人员信息表.xlsx";
						URL u = new URL(url);
						u.openConnection();
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
