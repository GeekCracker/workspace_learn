package com.day20190930.test1;

public class Test {

    /**
     * volatile �ᱻ�����lock���ָ������������еĲ��������ȴ���MESIЭ�飬MESIʧЧ����I/O����
     */
    public static volatile boolean isKeep = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!isKeep){
                }
                System.out.println("��̽���޸�");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("�޸�ֵ");
                isKeep = true;
            }
        }).start();
    }
}
