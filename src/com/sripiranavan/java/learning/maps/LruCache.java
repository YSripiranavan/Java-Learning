package com.sripiranavan.java.learning.maps;

public interface LruCache {
	int get(int key);

	void put(int key, int value);

	void setCapacity(int capacity);
}
