package com.sripiranavan.java.learning.multithread.synchronizers;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CyclicBarrierDemo {
	private static final int NUMBER_OF_THREADS = 4;
	private static final int NUMBERS_TO_GENERATE = 3;
	private static final int MAXIMUM_RANDOM_NUMBER = 100;

	private static CyclicBarrier barrier;
	private List<Integer> generatedNumbers = new CopyOnWriteArrayList<Integer>();
	private Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		var demo = new CyclicBarrierDemo();
		barrier = new CyclicBarrier(NUMBER_OF_THREADS, demo::numberGenerationCallback);

		var es = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		IntStream.range(0, NUMBER_OF_THREADS).forEach(i -> es.submit(demo::generateNumbers));
		System.out.println("getParties(): " + barrier.getParties());

		es.shutdown();
		es.awaitTermination(5, TimeUnit.SECONDS);
		es.shutdownNow();
	}

	private void numberGenerationCallback() {
		int max = generatedNumbers.stream().mapToInt(i -> i).max().getAsInt();
		System.out.println("All generated Numbers: " + generatedNumbers);
		System.out.println("Maximum: " + max);
	}

	private void generateNumbers() {
		for (int i = 0; i < NUMBERS_TO_GENERATE; i++) {
			generatedNumbers.add(r.nextInt(MAXIMUM_RANDOM_NUMBER));
		}

		try {
			System.out.println("await(): " + barrier.await());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
