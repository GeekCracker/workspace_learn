package com.day20190914.test1;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String [] arr = {"abc","abcd","ddddd"};
        List<String> list = Arrays.asList(arr);
        list.forEach(item-> System.out.println(item));
        list.remove(0);
        list.stream().filter(item->item.length() > 3).forEach(item-> System.out.println(item));
    }
}
