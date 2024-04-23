package com.learning.cache;

public class LRUCacheTest {
	public static void main(String[] args) {
		cache.LRUCache cache = new cache.LRUCache(10);
		cache.add("ABC");
		cache.add("DEF");
		cache.add("GHI");
		cache.add("JKL");
		cache.add("MNO");
		cache.add("PQR");
		cache.add("STU");
		cache.add("VWZ");
		System.out.println(cache.toString());
		cache.add("MNO");
		System.out.println(cache.toString());
		cache.add("YYS");
		cache.add("YTR");
		cache.add("KTR");
		cache.add("WRR");
		cache.add("SQQ");
		System.out.println(cache.toString());
		
		cache.get("PQR");
		cache.get("YTR");
		cache.get("KTR");
		System.out.println(cache.toString());
		cache.get("DEF");
	}
}
