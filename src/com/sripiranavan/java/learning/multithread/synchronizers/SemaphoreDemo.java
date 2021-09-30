package com.sripiranavan.java.learning.multithread.synchronizers;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreDemo {

	private Semaphore semaphore;

	public SemaphoreDemo(int slotLimit) {
		semaphore = new Semaphore(slotLimit);
	}

	public static void main(String[] args) throws InterruptedException {
		int loginPermits = 10;
		var es = Executors.newFixedThreadPool(4);
		var demo = new SemaphoreDemo(loginPermits);
		IntStream.range(0, loginPermits).forEach(user -> es.submit(demo::tryLogin));

		es.shutdown();
		es.awaitTermination(2, TimeUnit.SECONDS);

		System.out.println("availabelPermitsForLogin:\t" + demo.availablePermitsForLogin());
		demo.tryLogin();

		demo.logout();
		System.out.println("availabelPermitsForLogin:\t" + demo.availablePermitsForLogin());
	}

	private void tryLogin() {
		if (semaphore.tryAcquire()) {
			System.out.println("Congrats! You are logged in!");
		} else {
			System.out.println("No permits for login. Please try again lateer");
		}
	}

	private void logout() {
		semaphore.release();
	}

	private int availablePermitsForLogin() {
		return semaphore.availablePermits();
	}
}
