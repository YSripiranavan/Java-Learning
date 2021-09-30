package com.sripiranavan.java.learning.multithread.hw;

import java.util.concurrent.TimeUnit;

public class Task3 implements Runnable {

	public int counter1 = 0;
	public int counter2 = 0;

	@Override
	public void run() {
		try {
			synchronized (this) {
				while (true) {
					System.out.println(counter1 + " == " + counter2);
					counter1++;
					TimeUnit.MILLISECONDS.sleep(10);
					counter2++;
					TimeUnit.MILLISECONDS.sleep(10);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Thread was interrupted");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Task3 obj = new Task3();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		
		t1.start();
		t2.start();
		
		TimeUnit.SECONDS.sleep(3);
		t1.interrupt();
		t2.interrupt();
	}

}
