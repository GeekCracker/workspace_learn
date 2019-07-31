package com.day20190501.test1;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		File file = new File("C:\\Windows");
		File [] fileList = file.listFiles();
		for(File f : fileList){
			if(f.isDirectory()){
				System.out.print(f.getName());
				System.out.println(">>"+f.length()/1024);
			}
		}
	}
}
