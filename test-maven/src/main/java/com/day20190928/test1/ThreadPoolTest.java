package com.day20190928.test1;

import java.util.concurrent.CountDownLatch;

public class ThreadPoolTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){

        new StringBuffer().append("");
        new StringBuilder().append(1);
        CountDownLatch latch = new CountDownLatch(5);

        for(int i = 0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(latch.getCount());
                    latch.countDown();
                    /*try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("线程池执行完了");

    }

}
