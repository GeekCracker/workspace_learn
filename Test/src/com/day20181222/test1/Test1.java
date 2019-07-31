package com.day20181222.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		Integer count = 10;
		String weekStr = "星期一,星期二,星期三,星期四";
		System.out.println(getList(count,weekStr.split(",")));;
	}
	
	public static List<String> getList(Integer count,String [] arrWeek){
		List<String> listWeek = new ArrayList<String>();
		for(int i = 0;i<count / arrWeek.length;i++){
			listWeek.addAll(Arrays.asList(arrWeek));
		}
		for(int i = 0;i<count % arrWeek.length;i++){
			listWeek.add(arrWeek[i]);
		}
		return listWeek;
	}
	
}
