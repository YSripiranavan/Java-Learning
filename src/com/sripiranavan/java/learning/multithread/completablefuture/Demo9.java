package com.sripiranavan.java.learning.multithread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo9 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "First").thenAcceptBoth(
				CompletableFuture.supplyAsync(() -> "Second"), (s1, s2) -> System.out.println(s1 + " " + s2));
		System.out.println(future.get());
	}

}
