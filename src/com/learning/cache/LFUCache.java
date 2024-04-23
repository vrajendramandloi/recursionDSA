package com.learning.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LFUCache {
	Map<Integer, Set<String>> freqTracker = new HashMap<Integer, Set<String>>();
	Map<String, String> cache = new HashMap<String, String>();
	int cacheSize;
	
	public LFUCache(int size) {
		this.cacheSize = size;
	}
	
	public void add() {
		if(cacheSize < cache.size()) {
			cache.put(null, null);
		}
	}
}
