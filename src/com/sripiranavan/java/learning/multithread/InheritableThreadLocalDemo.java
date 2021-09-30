package com.sripiranavan.java.learning.multithread;

import java.util.concurrent.TimeUnit;

public class InheritableThreadLocalDemo {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();

	public static void main(String[] args) {
		var thread1 = new Thread(() -> {
			System.out.println("##### Thread 1 #####");
			threadLocal.set("----- Thread 1 - ThreadLocal -----");
			inheritableThreadLocal.set("----- Thread 1 - InheritableThreadeLocal -----");

			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());

			var childThread = new Thread(() -> {
				System.out.println("***** ChildThread *****");
				System.out.println(threadLocal.get());
				System.out.println(inheritableThreadLocal.get());
			});
			childThread.start();
		});

		thread1.start();

		var thread2 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("##### Thread 2 #####");
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
		});
		thread2.start();
	}

}
