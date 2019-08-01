package com.day20190731.test1;

public class Test {

    private static Integer count = 0;

    private static Object object = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (object) {
                        count++;
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

}
