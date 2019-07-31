package com.day20190508.test1;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		Integer [] arr1 = {1,6,3};
		Integer [] arr2 = {2,5,4};
		System.out.println(Arrays.toString(merge(arr1,arr2)));
	}
	
	public static Integer [] merge(Integer [] arr1,Integer [] arr2){
		Collection<Integer> collection = new TreeSet<Integer>();
		
		collection.addAll(Arrays.asList(arr1));
		collection.addAll(Arrays.asList(arr2));
		
		Integer [] arr3 = new Integer[collection.size()];
		collection.toArray(arr3);
		
		return arr3;
	}
}
