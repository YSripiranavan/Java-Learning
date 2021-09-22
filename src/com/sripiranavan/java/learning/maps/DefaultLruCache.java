package com.sripiranavan.java.learning.maps;

import java.util.LinkedHashMap;

public class DefaultLruCache extends LinkedHashMap<Integer, Integer> implements LruCache {
	private int capacity;

	public DefaultLruCache() {
		super(16, 0.75f, true);
	}

	public DefaultLruCache(int capacity) {
		super(16, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	public int get(int key) {
		Integer result = super.get(key);
		if (result == null) {
			return -1;
		}
		return super.get(key);
	}

	@Override
	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
		if (size() > capacity) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		DefaultLruCache cache = new DefaultLruCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}

}
