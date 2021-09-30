package com.sripiranavan.java.learning.multithread.hw;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {
		ByteArrayInputStream bais = new ByteArrayInputStream(new byte[] { '\n' });
		int[] latency = { 1000, 1000, 1000, 1000, 1000, 1000 };
		String[] messages = { "First message", "Second message", "Third message", "Fourth message", "Fifth message",
				"Sixth message" };

		Spam spam = new Spam(latency, messages);
		
		spam.startSpam();
		
		TimeUnit.SECONDS.sleep(5);
		System.setIn(bais);
	}

	private static class Spam implements Runnable {
		private int[] latency;
		private String[] messages;

		public Spam(int[] latency, String[] messages) {
			if (latency.length != messages.length) {
				throw new IllegalArgumentException("Error, Arrays of latency and messages are not equal");
			}
			this.latency = latency;
			this.messages = messages;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < messages.length; i++) {
					TimeUnit.MILLISECONDS.sleep(latency[i]);
					System.out.println(messages[i]);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private class Listener implements Runnable {
			private Thread thread;
			public static final InputStream IN_DEFAULT = System.in;

			public Listener(Thread thread) {
				super();
				this.thread = thread;
			}

			@Override
			public void run() {
				try {
					while (true) {
						if (System.in.available() > 0 && System.in.read() == '\n') {
							System.setIn(IN_DEFAULT);
							thread.interrupt();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		public void startSpam() {
			var spam = new Thread(this);
			var listener = new Thread(new Listener(spam));

			spam.start();
			listener.setDaemon(true);
		}
	}
}
