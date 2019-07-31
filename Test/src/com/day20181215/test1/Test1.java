package com.day20181215.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Test1 {

	public static void main(String[] args) {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				try {
					// InetAddress ip =
					// InetAddress.getByName("www.xumengba.com");
					/*
					 * System.out.println("IP地址:"+ip.getHostAddress());
					 * System.out.println("域名："+ip.getHostName());
					 */
					/*
					 * InetAddress[] ips =
					 * InetAddress.getAllByName("http://www.baidu.com"); for
					 * (InetAddress inetAddress : ips) {
					 */
					/*
					 * System.out.println("IP地址:" +
					 * inetAddress.getHostAddress()); System.out.println("域名：" +
					 * inetAddress.getHostName());
					 */
					URL url = new URL("http://192.168.2.27/main.html");
					URLConnection con = url.openConnection();
					InputStream is = con.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					StringBuilder sb = new StringBuilder();
					String str = null;
					while ((str = br.readLine()) != null) {
						sb.append(str);
						sb.append("\n");
					}
					System.out.println(sb.toString());
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		};
		for (int i = 0; i < 2000; i++) {
			Thread thread = new Thread(run, "Thread-" + i);
			thread.start();
		}
	}
}
