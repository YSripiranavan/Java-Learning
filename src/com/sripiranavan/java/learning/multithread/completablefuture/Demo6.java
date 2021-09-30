package com.sripiranavan.java.learning.multithread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo6 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var future = CompletableFuture.runAsync(() -> {
			System.out.println("Saving User Profile via external API");
		}).thenRun(() -> {
			System.out.println("User Profile Saved!");
		});

		System.out.println(future.get());

		var es = Executors.newCachedThreadPool();
		CompletableFuture.runAsync(() -> {
			System.out.println("Saving User profile via external API");
		}).thenRunAsync(() -> {
			System.out.println("User profile saved!");
		}, es);

		es.shutdown();
		es.awaitTermination(2, TimeUnit.SECONDS);
		es.shutdownNow();
	}

}
