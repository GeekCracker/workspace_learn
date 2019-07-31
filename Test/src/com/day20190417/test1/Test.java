package com.day20190417.test1;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Test {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
//					while(true){
						System.out.println("开始请求");
						String url = "http://localhost:9989/xoffice/xoffice?_key=false&_xformat=xls&_format=html&_file=";
						url += "http://localhost:7766/static/image/upload/2019/03/13/21/1a2d176285ba4057b6bfd2d4c7e47f1b/"+URLEncoder.encode("管理人员信息表.xlsx","UTF-8");
						URL u = new URL(url);
						URLConnection connection = u.openConnection();
						InputStream is = connection.getInputStream();
						is.close();
//						Thread.sleep(1000);
//					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
