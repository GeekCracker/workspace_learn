package com.day20191101.test2;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        System.out.println("=="+Child.i+"==");
    }

}
class Parnent{
    public static final int i=new Random().nextInt();
    static {
        System.out.println("==2==");
    }
}
class Child extends Parnent{
    static{
        System.out.println("==3==");
    }
}