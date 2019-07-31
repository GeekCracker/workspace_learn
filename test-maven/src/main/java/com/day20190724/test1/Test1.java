package com.day20190724.test1;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		Integer [] arr1 = {1,2};
		Integer [] arr2 = {3,4};
		Integer [] arr3 = ArrayUtils.append(arr1);
		Arrays.asList(arr3).forEach(item->System.out.println(item));
	}
}
class ArrayUtils{
	
	public static <T> T[] append(T[]... source){
		for(int i = 1;i<source.length;i++){
			int destLength = source[0].length;
			int srcLength = source[i].length;
			source[0] = Arrays.copyOf(source[0],destLength + srcLength);
			System.arraycopy(source[i], 0, source[0], destLength, srcLength);
		}
		return source[0];
	}
}