package com.day20190816.test1;

import java.util.concurrent.locks.ReentrantLock;

public class Test_可重入锁 {
    public static void main(String[] args) {
        //在这里，test1、test2、test3的锁都是test_可重入锁这个对象锁，在test1获取到锁时，test2和test3都可以获取到该锁，所以synchronized是可重入锁
        Test_可重入锁 test_可重入锁 = new Test_可重入锁();
        test_可重入锁.test1();

        test_可重入锁.test4();

    }

    private synchronized void test1(){
        test2();
        System.out.println("=======test1======");
    }
    private synchronized void test2(){
        test3();
        System.out.println("=======test2======");
    }
    private synchronized void test3(){
        System.out.println("=======test3======");
    }

    private void test4(){
        //可重入锁
        ReentrantLock reentrantLock = new ReentrantLock();
        int num = 3;
        System.out.println("=========开始加锁=====");
        for(int i = 0;i<num;i++){
            reentrantLock.lock();
        }
        for(int i = 0;i<num;i++){
            reentrantLock.unlock();
        }
        System.out.println("========释放锁========");
    }

    private void test5(){
        System.out.println("=======test5======");
    }
}
