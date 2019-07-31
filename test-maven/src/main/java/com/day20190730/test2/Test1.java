package com.day20190730.test2;

public class Test1 {

	private static Integer count = 0;

	private static Object obj = new Object();

	public static void main(String[] args) {

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0;i<1000;i++){
					synchronized (obj){
						count++;
					}
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0;i<1000;i++){
					synchronized (obj){
						count++;
					}
				}
			}
		});
		thread1.start();
		thread2.start();

		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);
	}
}
