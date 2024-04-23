package collectiontest;

import java.util.LinkedList;

public class BlockingListImpl {
	LinkedList<String> list;
	int length;
	
	public BlockingListImpl(int size) {
		this.length= size;
		list = new LinkedList<String>();
	}
	
	public void offer(String str) throws InterruptedException {
		if(list.size() < length -1) {
			list.offer(str);
		} else {
			wait();
		}
	}
	
	public String poll() {
		if(list.size() == length -1) {
			notifyAll();
		}
		return list.poll();
	}
} 
