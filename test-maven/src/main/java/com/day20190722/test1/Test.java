package com.day20190722.test1;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class Test {

	public static void main(String[] args) {
		String str = "zhang,li,sun,zhu,liu,wen";
		String [] arr = StringUtils.splitByWholeSeparator(str, ",");
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
		
		arr = str.split(",");
		System.out.println(Arrays.toString(arr));
	}
}
