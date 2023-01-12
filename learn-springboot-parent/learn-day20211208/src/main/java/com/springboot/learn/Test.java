package com.springboot.learn;

/**
 * @description: volatile 测试
 * @author: 朱俊亮
 * @time: 2021-12-08 17:04
 */
public class Test {

    //https://www.cnblogs.com/dolphin0520/p/3920373.html
    private volatile Integer count = 0;

    public synchronized void add(){
        count++;
//        System.out.println(Thread.currentThread().getName() + ":" + count);
    }


    public static void main(String[] args) {
        Test test = new Test();
        long time = System.currentTimeMillis();
        for(int i = 0;i < 10;i++){
            new Thread(() -> {
                for(int j = 0;j < 1000000000;j++){
                    test.add();
                }
            }).start();
        }
        while(Thread.activeCount()>2)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println("消耗："+(System.currentTimeMillis() - time)+"毫秒");
        System.out.println(test.count);
    }
}
