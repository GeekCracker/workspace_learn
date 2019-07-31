package com.day20190505.test1;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

public class Test {

	public static void main(String[] args) {
		Character ch = '\u0000';
		char a = 'уе';
		String b = "\u0000уе";
		String c = "\u0000";
		String d = "\u0001";
		Boolean flag1 = Character.isDefined('a');
		Boolean flag2 = Character.isDefined(ch);
		/*Boolean flag3 = Character.isDefined(a.charAt(0));
		Boolean flag4 = Character.isDefined(a.charAt(1));*/
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(Character.isUnicodeIdentifierStart(a));
		System.out.println(Character.isUnicodeIdentifierPart(a));
		/*System.out.println(flag3);
		System.out.println(flag4);*/
		System.out.println(b.startsWith("\\"));
		System.out.println(b.startsWith("\\\\"));
		System.out.println(Character.isDigit(ch));
		System.out.println(Character.isDigit(a));
		try {
			System.out.println(URLDecoder.decode(b,"UTF-8"));
			System.out.println(URLEncoder.encode(b,"UTF-8"));
			System.out.println(URLEncoder.encode(c,"UTF-8"));
			System.out.println(URLEncoder.encode(d,"UTF-8"));
			System.out.println("==================");
			System.out.println(URLEncoder.encode("\u0000","UTF-8"));
			System.out.println(URLEncoder.encode("\u0001","UTF-8"));
			System.out.println(URLEncoder.encode("\u0002","UTF-8"));
			System.out.println(URLEncoder.encode("\u0003","UTF-8"));
			System.out.println(URLEncoder.encode("\u9999","UTF-8"));
			String base64 = Base64.getEncoder().encodeToString("\u0000".getBytes());
			System.out.println("base64:"+base64);;
			System.out.println(new String("\u0000".getBytes("ISO-8859-1"),"UTF-8").equals("\u0000"));
			System.out.println(URLEncoder.encode(new String("\u0000".getBytes("ISO-8859-1")),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
