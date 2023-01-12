package com.springboot.learn.boot;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: Java锁
 * @author: 朱俊亮
 * @time: 2021-12-23 17:56
 */
public class LearnLockRun {

    public static void main(String[] args) {
        LearnLockRun lockRun = new LearnLockRun();
        lockRun.test1();
    }

    public void test1(){
        ReentrantLock lock = new ReentrantLock(true);

        for(int i = 0;i<3;i++){
            lock.lock();
        }
        for(int i = 0;i<2;i++){
            try {

            }finally {
                lock.unlock();
            }
        }
    }
}
