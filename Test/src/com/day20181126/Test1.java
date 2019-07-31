package com.day20181126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("d");
		list.add("b");
		list.add("e");
		list.add("c");
		Collections.sort(list, (a,b)->a.compareTo(b));
		System.out.println(list);
	}
}
