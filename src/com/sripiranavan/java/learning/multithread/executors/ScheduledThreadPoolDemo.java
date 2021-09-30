package com.sripiranavan.java.learning.multithread.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

	public static void main(String[] args) {
		var es = Executors.newScheduledThreadPool(4);
		es.schedule(() -> System.out.println("Schedule example: " + Thread.currentThread().getName()), 1,
				TimeUnit.SECONDS);
		es.shutdown();
		try {
			es.awaitTermination(4, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			es.shutdownNow();
		}
	}

}
