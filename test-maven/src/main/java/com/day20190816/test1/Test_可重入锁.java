package com.day20190816.test1;

import java.util.concurrent.locks.ReentrantLock;

public class Test_�������� {
    public static void main(String[] args) {
        //�����test1��test2��test3��������test_���������������������test1��ȡ����ʱ��test2��test3�����Ի�ȡ������������synchronized�ǿ�������
        Test_�������� test_�������� = new Test_��������();
        test_��������.test1();

        test_��������.test4();

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
        //��������
        ReentrantLock reentrantLock = new ReentrantLock();
        int num = 3;
        System.out.println("=========��ʼ����=====");
        for(int i = 0;i<num;i++){
            reentrantLock.lock();
        }
        for(int i = 0;i<num;i++){
            reentrantLock.unlock();
        }
        System.out.println("========�ͷ���========");
    }

    private void test5(){
        System.out.println("=======test5======");
    }
}
