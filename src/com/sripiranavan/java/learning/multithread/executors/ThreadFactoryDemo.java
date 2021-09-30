package com.sripiranavan.java.learning.multithread.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadFactoryDemo {

	public static void main(String[] args) {
		int threadNum = 4;
		var es = Executors.newFixedThreadPool(threadNum, new DefaultThreadFactory());
//    	with runnable
		IntStream.range(0, threadNum).forEach(i -> {
			es.submit(() -> System.out.println(Thread.currentThread().getName()));
		});

//		with callable
//		IntStream.range(0, threadNum).forEach(i -> {
//			Future<Integer> future = es.submit(() -> {
//				System.out.println(Thread.currentThread().getName());
//				return i;
//			});
//
//			try {
//				System.out.println("Result: " + future.get());
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			}
//		});

		es.shutdown();

		try {
			es.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			es.shutdownNow();
		}

	}

}

class DefaultThreadFactory implements ThreadFactory {
	private AtomicInteger counter = new AtomicInteger();

	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r, "Custom Thread Factory | Thread #" + counter.getAndIncrement());
	}

}