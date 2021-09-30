package com.sripiranavan.java.learning.multithread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteWithExecutorServiceDemo {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(()->System.out.println("Hello from thread "+Thread.currentThread().getName()));
		es.execute(()->System.out.println("Hello from thread "+Thread.currentThread().getName()));
	}

}
