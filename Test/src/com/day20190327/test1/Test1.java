package com.day20190327.test1;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {
		String str = "D:\\canlian\\resources";
		
		File file = new File("D:/canlian/resources/static/image/upload/2019/03/05/13/1e71819187fe458bbec39add0e62bf43_0f621514c1234649827a1ab3361230fa_67c1186483a2d0f05cb357c29e96c3a8.jpg");
		System.out.println(str);
		System.out.println(file.getAbsolutePath().replace(str,""));
		System.out.println(file.getAbsolutePath().replace(str+"\\","").replace(file.getName(),"").replaceAll("\\\\","/"));
	}
}
