package com.sripiranavan.java.learning.multithread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThrowingExceptionFromRunnableDemo {

	public static void main(String[] args) {
		var t1 = new Thread(()->{
			try {
				Files.readString(Paths.get("non-existing"));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
		
		t1.start();
	}

}
