package com.sripiranavan.java.learning.multithread.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task5_v1 {
	private static final int ITERATION_NUMBER = 3;
	private static final int READERS_NUMBER = 3;
	private static final StringBuilder BUFFER = new StringBuilder();
	private static final int BUFFER_LENGTH = 5;
	private static final int PAUSE = 5;
	private static boolean stop;
	private static boolean isWrittenToBuffer;
	private static volatile int readersRead = READERS_NUMBER;
	private static final Object MONITOR = new Object();

	private static class Reader extends Thread {

		@Override
		public void run() {
			while (!stop) {
				if (readersRead == 0) {
					try {
						synchronized (MONITOR) {
							read(getName());
							if (readersRead == READERS_NUMBER) {
								isWrittenToBuffer = false;
								MONITOR.notify();
							}
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	private static void read(String threadName) throws InterruptedException {
		System.out.printf("Reader %s:", threadName);
		for (int j = 0; j < BUFFER_LENGTH; j++) {
			Thread.sleep(PAUSE);
			System.out.print(BUFFER.charAt(j));
		}
		System.out.println();
		readersRead++;
		Thread.sleep(5);
	}

	private static class Writer extends Thread {

		@Override
		public void run() {
			int tact = 0;
			while (!stop) {
				try {
					synchronized (MONITOR) {
						write();
						while (isWrittenToBuffer) {
							MONITOR.wait();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					if (++tact == ITERATION_NUMBER) {
						stop = true;
					}
				}
			}
		}

	}

	private static void write() throws InterruptedException {
		BUFFER.setLength(0);
		System.err.print("Writer writes:");
		Random random = new Random();
		for (int j = 0; j < BUFFER_LENGTH; j++) {
			Thread.sleep(PAUSE);
			char ch = (char) ('A' + random.nextInt(26));
			System.err.print(ch);
			BUFFER.append(ch);
		}
		System.err.println();
		Thread.sleep(5);
		isWrittenToBuffer = true;
		readersRead = 0;
	}

	public static void main(String[] args) {
		Writer writer = new Writer();
		List<Thread> readers = new ArrayList<Thread>();
		for (int j = 0; j < READERS_NUMBER; j++) {
			readers.add(new Reader());
		}
		for (Thread reader : readers) {
			reader.start();
		}
		writer.start();
	}

}
