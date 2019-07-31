package com.day20190404.test1;

import java.net.URLEncoder;

public class Test1 {

	public static void main(String[] args)throws Exception {
		String url = "+уехЩ.txt";
		String aa = URLEncoder.encode(url,"UTF-8");
		System.out.println(aa);
	}
}
