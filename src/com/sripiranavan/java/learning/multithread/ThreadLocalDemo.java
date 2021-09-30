package com.sripiranavan.java.learning.multithread;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo implements Runnable {
//	private static ThreadLocal<String> transactionId = ThreadLocal.withInitial(() -> "n/a");
	private static ThreadLocal<Integer> transactionId = new ThreadLocal<Integer>();

	@Override
	public void run() {
		transactionId.set((int) (Math.random() * 100));

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(transactionId.get());
	}

	public static void main(String[] args) {
		ThreadLocalDemo runnable = new ThreadLocalDemo();

		var thread1 = new Thread(runnable, "Thread-1");
		var thread2 = new Thread(runnable, "Thread-2");

		thread1.start();
		thread2.start();
	}

}
