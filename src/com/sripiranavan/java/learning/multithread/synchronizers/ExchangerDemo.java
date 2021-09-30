package com.sripiranavan.java.learning.multithread.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();

		Runnable task1 = () -> {
			try {
				String msg = exchanger.exchange("Message From task#1");
				System.out.println("Received from another thread in task #1:" + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable task2 = () -> {
			try {
				String msg = exchanger.exchange("Message From task#2");
				System.out.println("Received from another thread in task #2:" + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		var es = Executors.newCachedThreadPool();
		es.submit(task1);
		es.submit(task2);

		try {
			es.shutdown();
			es.awaitTermination(5, TimeUnit.SECONDS);
			es.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
