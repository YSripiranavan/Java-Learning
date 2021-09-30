package com.sripiranavan.java.learning.multithread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo5 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Request user profile from external API");
			return "Some string representation of User Profile";
		}).thenAccept(result -> {
			System.out.println("User Profile received: " + result);
		});
		System.out.println(future.get());

		var es = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			System.out.println("Request user profile from external API");
			return "Some string representation of User Profile";
		}).thenAcceptAsync(result -> {
			System.out.println("User Profile received: " + result);
		}, es);
		es.shutdown();
		es.awaitTermination(2, TimeUnit.SECONDS);
		es.shutdownNow();
	}

}
