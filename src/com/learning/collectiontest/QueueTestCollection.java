package collectiontest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTestCollection {
	public static void main(String[] args) {
		testArrayBlockkingQueue();
		testLinkedQueue();
		testLinkedBlockkingQueue();
	}
	
	static void testArrayBlockkingQueue() {
		try {
			Queue<String> strQueue = new ArrayBlockingQueue<String>(5);
			strQueue.offer("abc");
			strQueue.offer("asd");
			strQueue.offer("qwe");
			strQueue.offer("ewrt");
			strQueue.offer("www");
			System.out.println("ArrayQueue "+strQueue.toString());
			
			strQueue.add("wyyu");
			System.out.println("ArrayQueue "+strQueue.toString());
			strQueue.offer("wyyu");
			strQueue.poll();
			System.out.println("ArrayQueue "+strQueue.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void testLinkedBlockkingQueue() {
		try {
			Queue<String> strQueue = new LinkedBlockingQueue<String>(5);
			strQueue.offer("abc");
			strQueue.offer("asd");
			strQueue.offer("qwe");
			strQueue.offer("ewrt");
			strQueue.offer("www");
			System.out.println("Linked Blocking queue Poll "+strQueue.toString());
			
			strQueue.offer("wyyu");
			System.out.println("Linked Blocking queue Poll "+strQueue.toString());
			strQueue.offer("wyyu");
			strQueue.poll();
			System.out.println("Linked Blocking queue Poll "+strQueue.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void testLinkedQueue() {
	try {
		Queue<String> strQueue = new LinkedList<String>();
		strQueue.offer("abc");
		strQueue.offer("asd");
		strQueue.offer("qwe");
		strQueue.offer("ewrt");
		strQueue.offer("www");
		System.out.println("linked list post polll"+strQueue.toString());
		strQueue.add("wyyu");
		System.out.println("linked list post polll"+strQueue.toString());
		strQueue.offer("qwew1");
		strQueue.poll();
		System.out.println("linked list post polll"+strQueue.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
