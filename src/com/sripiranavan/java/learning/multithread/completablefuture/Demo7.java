package com.sripiranavan.java.learning.multithread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo7 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<CompletableFuture<Double>> result1 = getUserDetailsById(125)
				.thenApply(userDetails -> getCreditRating(userDetails));
		System.out.println(result1.get().get());

		var result2 = getUserDetailsById(125).thenCompose(userDetails -> getCreditRating(userDetails));
		System.out.println(result2.get());
	}

	private static CompletableFuture<String> getUserDetailsById(int userId) {
		return CompletableFuture.supplyAsync(() -> {
			return "User details String";
		});
	}

	private static CompletableFuture<Double> getCreditRating(String userDetails) {
		return CompletableFuture.supplyAsync(() -> {
			return 101.91;
		});
	}
}
