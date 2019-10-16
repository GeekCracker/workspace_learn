package com.day20190930.test2;

import java.util.concurrent.locks.Lock;

public class Test {

    public static volatile Integer count = 0;

    public static Object object = new Object();

    public static void main(String[] args) {

        for(int i = 0;i<10;i++){
            synchronized (object){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int j = 0;j<1000;j++){
                            count++;
                        }
                    }
                }).start();
            }

        }
        System.out.println(count);
    }
}
