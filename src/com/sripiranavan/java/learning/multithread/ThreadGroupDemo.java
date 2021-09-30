package com.sripiranavan.java.learning.multithread;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDemo {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup threadGroup = new ThreadGroup("group");

		var t0 = new Thread(threadGroup, ThreadGroupDemo::execute);
		var t1 = new Thread(threadGroup, ThreadGroupDemo::execute);
		var t2 = new Thread(threadGroup, ThreadGroupDemo::execute);
		var t3 = new Thread(threadGroup, ThreadGroupDemo::execute);
		var t4 = new Thread(threadGroup, ThreadGroupDemo::execute);

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		TimeUnit.SECONDS.sleep(2);
		threadGroup.interrupt();
	}

	public static void execute() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
