package com.sripiranavan.java.learning.multithread.hw;

import java.util.concurrent.TimeUnit;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		var t1 = new Thread(new RunnableTask());
		var t2 = new DefaultThread();
		var t3 = new Thread(() -> {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		var t4 = new Thread(Task1::printThreadName);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		TimeUnit.SECONDS.sleep(2);
	}

	private static class RunnableTask implements Runnable {
		@Override
		public void run() {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static class DefaultThread extends Thread {

		@Override
		public void run() {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static void printThreadName() {
		while (true) {
			System.out.println(Thread.currentThread().getName());
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
