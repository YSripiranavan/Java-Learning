package com.sripiranavan.java.learning.multithread.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CountDownLatchDemo {
	private static final int COUNT = 4;
	private static int countdown = 0;

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(COUNT);
		var es = Executors.newFixedThreadPool(2);

		IntStream.range(0, COUNT).forEach(i -> es.submit(new Worker(countDownLatch)));

		countDownLatch.await();
		System.out.println("Latch is released");

		es.shutdown();
		es.awaitTermination(5, TimeUnit.SECONDS);
		es.shutdownNow();
	}

	private static class Worker implements Runnable {
		private CountDownLatch countDownLatch;

		public Worker(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			System.out.println("do some work...");
			System.out.println("Counted down " + countdown++);
			countDownLatch.countDown();
		}
	}

}
