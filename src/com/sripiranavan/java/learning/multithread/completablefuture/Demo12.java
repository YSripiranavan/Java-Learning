package com.sripiranavan.java.learning.multithread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo12 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			int i = 5;
			i /= 0;
			return i++;
		}).handle((result, exce) -> {
			if (exce != null) {
				System.out.println("Exception happend during the execution " + exce.getClass());
				System.out.println("Exception is caused by: " + exce.getCause());
			}
			return result;
		});
		System.out.println(future.get());

		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
			int i = 5;
			i /= 0;
			return i++;
		}).exceptionally((exec) -> {
			if (exec != null) {
				System.out.println("Exception happend during the exection " + exec.getClass());
				System.out.println("Exception is caused by: " + exec.getCause());
			}
			return 10;
		});
		System.err.println(future2.get());
	}

}
