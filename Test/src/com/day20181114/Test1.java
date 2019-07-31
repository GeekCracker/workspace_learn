package com.day20181114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {

	public static void main(String[] args) {
		char a = 'A';
		Character [] ch = {'b','a','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'0','1','2','3','4','5','6','7','8','9'};
		Set<Character> set = new TreeSet<Character>(Arrays.asList(ch));
		List<Character> list = new ArrayList<Character>(set);
		List<Character> list1 = new ArrayList<Character>(Arrays.asList(ch));
		System.out.println(set);
		
		System.out.println(list);
		System.out.println(list1);
	}
}

