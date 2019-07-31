package com.day20181109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		/*Integer [] arr1 ={1,2,3};
		List<Integer> aa = Arrays.asList(arr1);
		arr1[0]=2;
		System.out.println(arr1.equals(aa.get(0)));*/
		Person [] arr = {new Person(),new Person(),new Person()};
		List<Person> list = Arrays.asList(arr);
		//list.add(new Person());
		System.out.println(arr[0]);
		//arr[0] = new Person();
		System.out.println(list.get(0));
		
		
		List<Person> list1 = new ArrayList<Person>();
		for(Person person : arr){
			list1.add(person);
		}
		System.out.println(list1.get(0));
		arr[0] = new Person();
		System.out.println(list1.get(0));
	}
}
class Person{
	
}