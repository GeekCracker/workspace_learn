package com.day20190317.test1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Test {

	public static void main(String[] args) throws Exception{
		InputStream is = new URL("http://111.231.111.161:7766/static/image/upload/2019/03/17/15/50650a6ce86e4f9f9482fc3b99edeb1e_%E8%80%83%E5%8B%A4%E6%95%B0%E6%8D%AE%E8%A1%A8.xls").openStream();
		FileOutputStream fos = new FileOutputStream("D://test.pdf");
		byte []  bt = new byte[4098];
		int len = 0;
		while((len = is.read(bt)) != -1){
			fos.write(bt,0,len);
		}
		fos.close();
		is.close();
	}
}
