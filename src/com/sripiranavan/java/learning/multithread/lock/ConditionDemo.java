package com.sripiranavan.java.learning.multithread.lock;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	private static final int CAPACITY = 5;

	private Deque<String> stack = new LinkedList<String>();
	private Lock lock = new ReentrantLock();
	private Condition stackEmptyCondition = lock.newCondition();
	private Condition stackFullCondition = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		var demo = new ConditionDemo();
		var es = Executors.newFixedThreadPool(4);
		
		es.submit(() -> demo.pushToStack("Test String #1"));
		es.submit(() -> System.out.println(demo.popFromStack()));

		es.shutdown();
		es.awaitTermination(5, TimeUnit.SECONDS);
		es.shutdownNow();
	}

	public void pushToStack(String item) {
		try {
			lock.lock();
			while (stack.size() == CAPACITY) {
				stackFullCondition.await();
			}
			stack.push(item);
			stackEmptyCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String popFromStack() {
		try {
			lock.lock();
			while (stack.size() == CAPACITY) {
				stackEmptyCondition.await();
			}
			return stack.pop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			stackFullCondition.signalAll();
			lock.unlock();
		}
		return "";
	}
}
