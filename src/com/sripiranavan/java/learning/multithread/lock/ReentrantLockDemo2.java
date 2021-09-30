package com.sripiranavan.java.learning.multithread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		var demo = new ReentrantLockDemo2();
		var es = Executors.newFixedThreadPool(4);
		
		es.execute(()->System.out.println(demo.calculate("+", 50, 8)));
		es.execute(()->System.out.println(demo.calculate("+", 60, 7)));
		es.execute(()->System.out.println(demo.calculate("+", 80, 5)));
		
		es.execute(()->System.out.println(demo.calculate("-", 50, 8)));
		es.execute(()->System.out.println(demo.calculate("-", 50, 8)));
		es.execute(()->System.out.println(demo.calculate("-", 50, 8)));
		
		terminateExecutorService(es);
	}

	public double add(double value1, double value2) {
		try {
			lock.lock();
			System.out.println("lock is acquired at Add Method");
			return value1 + value2;
		} finally {
			lock.unlock();
			System.out.println("lock is released at Add Method");
		}
	}

	public double subtract(double value1, double value2) {
		try {
			lock.lock();
			System.out.println("lock is acquired at Subtract Method");
			return value1 - value2;
		} finally {
			lock.unlock();
			System.out.println("lock is released at Subtract Method");
		}
	}

	public double calculate(String operation, double operand1, double operand2) {
		try {
			lock.lock();
			System.out.println("lock is acquired at Calculate Method");

			switch (operation) {
			case "+":
				return add(operand1, operand2);
			case "-":
				return subtract(operand1, operand2);
			default:
				System.out.println("Calculate works only with + and - operators and two values only");
				return 0;
			}
		} finally {
			lock.unlock();
			System.out.println("lock is released at Calculate Method");
		}
	}

	private static void terminateExecutorService(ExecutorService es) throws InterruptedException {
		es.shutdown();
		es.awaitTermination(3, TimeUnit.SECONDS);
		es.shutdownNow();
	}
}
