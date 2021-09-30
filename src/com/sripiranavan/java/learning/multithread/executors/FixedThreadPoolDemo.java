package com.sripiranavan.java.learning.multithread.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class FixedThreadPoolDemo {

	public static void main(String[] args) {
		ThreadPoolExecutor es = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

		IntStream.range(0, 4).forEach(i -> {
			es.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		es.shutdown();
		try {
			System.out.println("Pool size: " + es.getPoolSize());
			System.out.println("Queue size: " + es.getQueue().size());
			es.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			es.shutdownNow();
		}

		int numOfCores = Runtime.getRuntime().availableProcessors();
		System.out.println("Available processors: " + numOfCores);

//		var es2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	}

}
