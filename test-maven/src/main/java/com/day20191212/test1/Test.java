package com.day20191212.test1;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        String str = "%tF %tT";
        System.out.println(String.format(str,new Date(),new Date()));

    }
}
