package com.sripiranavan.java.learning.multithread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo8 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Retrieving weight");
		CompletableFuture<Double> weightInKgFuture = getWeight();

		System.out.println("Retrieving Height");
		CompletableFuture<Double> heightInCmFuture = getHeight();

		System.out.println("Calculating the Body Mass Index");
		CompletableFuture<Double> combineFuture = weightInKgFuture.thenCombine(heightInCmFuture,
				(weightInKg, heightInCm) -> {
					Double heightInMeter = heightInCm / 100;
					return weightInKg / (heightInMeter * heightInMeter);
				});
		System.out.println("BMI is : "+combineFuture.get());
	}

	private static CompletableFuture<Double> getWeight() {
		CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 75.0;
		});
		return weightInKgFuture;
	}

	private static CompletableFuture<Double> getHeight() {
		CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 175.9;
		});
		return heightInCmFuture;
	}
}
