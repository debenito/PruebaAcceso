package com.prueba.utils;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class ListProductSimilairsUtils<T> {
	
	HashMap<String,T> hashmap = new HashMap<>();
	
	
	public void add(String key,T object) {
		hashmap.put(key, object);
	}
	
	public boolean contains(String key) {
		return hashmap.containsKey(key);
	}
	
	public T get(String key) {
		return hashmap.get(key);
	}

}
