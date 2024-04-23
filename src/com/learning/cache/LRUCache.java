package cache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private final int DEFAULT_CACHE_SIZE = 50;
	private Map<String, Integer> map;
	private String[] queueStore;
	private int startIndex = -1;
	private int length;
	
	public LRUCache() {
		queueStore = new String[DEFAULT_CACHE_SIZE];
		map = new HashMap<String, Integer>(DEFAULT_CACHE_SIZE);
		length = DEFAULT_CACHE_SIZE;
	}
	
    public LRUCache(int size) {
    	length = size<=2 ? DEFAULT_CACHE_SIZE:size;
    	queueStore = new String[length];
    	map = new HashMap<String, Integer>(length);
    }
    
    public void add(String str) {
    	Integer index = map.get(str);
    	if(index != null) {
    		System.arraycopy(queueStore, index+1, queueStore, index, length-index-1);
    		realignMap();
    	} else if(startIndex < length-1) {
    		startIndex++;
    	} else if(startIndex == length-1) {
    		System.arraycopy(queueStore, 1, queueStore, 0, length-1);
    		realignMap();
    	}
    	queueStore[startIndex] =  str;
    	map.put(str, startIndex);
    }
    
    public void realignMap() {
    	for(int i = 0; i<queueStore.length; i++) {
    		map.put(queueStore[i], i);
    	}
    }
    
    public String get(String key) {
    	Integer index = map.get(key);
    	if(index != null) {
    		System.arraycopy(queueStore, index+1, queueStore, index, length-index-1);
    		realignMap();
    		queueStore[startIndex] =  key;
        	map.put(key, startIndex);
        	return key;
    	}
    	return null;
    }
        
    @Override
    public String toString() {
    	return "END [ "+Arrays.toString(queueStore)+"] START ";
    }
}