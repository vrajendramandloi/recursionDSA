package com.interview.hsbc;

public class TestSample {

	public static void main(String[] args) {
		// Array of 8 Elements..  2 numbers are misssing 
		// 1,2,3,4,5,6,7,8 <<- random 
		int[] arr = new int[] {7,4,5,1,2,3,8,9};
		int actualSize = 10;
		findMissingNumbers(arr, actualSize+1);
		
		//arr = new int[] {7,4,5,1,2,3,8,9};
		//actualSize = 20;
		
	}
	
	// O(n)
	public static void findMissingNumbers(int[] arr, int actualSize) {
		boolean[] freq = new boolean[actualSize];
		for(int val : arr) {
			freq[val] = true;
		}
		System.out.println("Missing Elements");
		for(int i=1; i<actualSize; i++) {
			if(freq[i] ==  false) 
				System.out.println(i);
		}
	}
}
