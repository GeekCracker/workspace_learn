package com.day20190930.test1;

public class Test {

    /**
     * volatile 会被编译成lock汇编指令，触发锁缓存行的操作，会先触发MESI协议，MESI失效会锁I/O总线
     */
    public static volatile boolean isKeep = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!isKeep){
                }
                System.out.println("嗅探到修改");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("修改值");
                isKeep = true;
            }
        }).start();
    }
}
