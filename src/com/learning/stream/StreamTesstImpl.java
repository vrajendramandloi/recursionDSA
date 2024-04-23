package com.learning.stream;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class StreamTesstImpl {

	public static void main(String[] args) {
		StreamTesstImpl t1 = new StreamTesstImpl();
		t1.ListStream();
		t1.priorityQueue();
		t1.doubleEndedQueue();
	}
	
	public void ListStream() {
		List<String> list = new ArrayList<String>();
		list.add("qq");list.add("qw");list.add("234");list.add("ert");list.add("we");list.add("tt");list.add("yu");list.add("ss");
		list.add("rr");list.add("yy");list.add("eew");list.add("wer");list.add("rty");list.add("tyut");list.add("yui");list.add("ghj");
		
		List<String> listWithQ = list.stream().filter(x -> x.contains("q")).collect(Collectors.toList());
		System.out.println(listWithQ.toString());
	}
	
	static class TestObj {
		private int a;
		private String b;
		public TestObj(int a, String b) {
			this.a = a;
			this.b = b;
		}
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
		public String getB() {
			return b;
		}
		public void setB(String b) {
			this.b = b;
		}
	} 
	
	public void convertListToMap() {
		List<TestObj> list = new ArrayList<StreamTesstImpl.TestObj>();
		list.add(new TestObj(1, "asd"));
		list.add(new TestObj(2, "asd"));
		list.add(new TestObj(3, "asd"));
		list.add(new TestObj(4, "asd"));
		list.add(new TestObj(5, "asd"));
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(TestObj::getA, TestObj::getB));
		System.out.println(map.toString());
	}
	
	public void MapStream() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "world");
		map.put("b", "qwe");
		map.put("c", "a");
		map.put("d", "wetr");
		map.put("e", "rty");
		map.put("f", "werwq");
	}
	
	public void priorityQueue() {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);
        System.out.println(pQueue.toString());
        System.out.println(pQueue.peek());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.peek());
	}
	
	public void doubleEndedQueue() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(15);
        System.out.println(queue.toString());
        
	}
}
