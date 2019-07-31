package com.day20190730.test2;

public class Test {

	public  static Integer count = 0;
	
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0;i<1000;i++){
					synchronized (count) {
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						count ++;
					}
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0;i<1000;i++){
					synchronized (count) {
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						count ++;
					}
				}
			}
		});
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);
		
	}
}
