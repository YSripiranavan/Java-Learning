package com.sripiranavan.java.learning.multithread;

import java.util.concurrent.TimeUnit;

public class InterruptDemo implements Runnable {

	@Override
	public void run() {

		try {
			System.out.println("in run() - about to work()");
			work();
			System.out.println("in run() - back from work() - this line will not be executed");
		} catch (InterruptedException e) {
			System.out.println("Error message : " + e.getMessage());
			// e.printStackTrace();
		}
		System.out.println("in run() - doing stuff after nap");
		System.out.println("in run() - leaving normally");
	}

	public void work() throws InterruptedException {
		while (true) {
			System.out.println("working....");
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("isInterrupted() " + Thread.currentThread().isInterrupted());
//			System.out.println("interrupted() " + Thread.interrupted());
				TimeUnit.MILLISECONDS.sleep(1);
				System.out.println("this line won't be executed");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		InterruptDemo runnableTask = new InterruptDemo();
		Thread thread = new Thread(runnableTask);
		thread.start();
		Thread.sleep(200);
		System.out.println("in main() - interrupting other thread");
		thread.interrupt();
		thread.join();
		System.out.println("in main() - leaving");
	}

}
