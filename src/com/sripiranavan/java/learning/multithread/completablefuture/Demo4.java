package com.sripiranavan.java.learning.multithread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Request UserId from exteranal API");
			return 1234;
		}).thenApply(result -> {
			System.out.println("Request total number of purchases in other service by Id: " + result);
			return 150;
		});

		System.out.println(future.get());

		var es = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			System.out.println("Request UserId from external API");
			return 1122;
		}).thenApplyAsync(result -> {
			System.out.println("Request total number of purchases in other service by Id: " + result);
			return 150;
		});

		es.shutdown();
		es.awaitTermination(2, TimeUnit.SECONDS);
		es.shutdownNow();
	}

}
