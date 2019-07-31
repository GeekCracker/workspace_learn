package com.day20181114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {
	public static void main(String[] args) {
		for(int i =0;i<2000;i++){
			System.out.println(getStr(i));
		}
	}
	public static Character [] ch = {'b','a','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
	};
	public static Set<Character> set = new TreeSet<Character>(Arrays.asList(ch));
	public static List<Character> listChar = new ArrayList<Character>(set);
	public static String getStr(Integer sort){
		return sort+1 > listChar.size() ? listChar.get(listChar.size()-1)+getStr(sort-listChar.size()) : listChar.get(sort)+"";
	}
}
