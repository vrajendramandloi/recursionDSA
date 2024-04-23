package com.learning.permComb;

import java.util.Arrays;

public class PrintPermutations {
	public static void main(String[] args) {
		String str = "ASD";
		printPermution(str , "");
		System.out.println("");
		printPermution2(str , 0, str.length());
		System.out.println("");
		str = "veer";
		printPermution(str , "");
		System.out.println("");
		printDistinctPermution(str , "");
		System.out.println("");
		System.out.println("printPermutationsTest ===================================================================================================");
		str = "ABCDE";
		printPermutationsTest(str, "");
		System.out.println("");
		System.out.println("printPermutationsTest3 ===================================================================================================");
		printPermutationsTest3(str, "");
		System.out.println("");
		System.out.println("printPermutationsTest ===================================================================================================");
		str = "ABCB";
		printPermutationsTest(str, "");
		System.out.println("");
		System.out.println("printPermutationsTest2 ===================================================================================================");
		str = "ABCB";
		printPermutationsTest2(str, "");
		System.out.println("");
		System.out.println("permuteArray ===================================================================================================");
		int[] arr = new int[] {12,34,44,32 }; //,11,34,56};
		permuteArray(arr, 0, arr.length-1);
	}
	
	static void permuteArray(int[] arr, int min, int max) {
        if (min == max) {
        	System.out.print(Arrays.toString(arr)+"     ");
        	return;
        }
        for (int i = min; i <= max; i++) {
            swap(arr, min, i);
            permuteArray(arr, min + 1, max);
            swap(arr, min, i); // backtrack
        }
    }
	static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
	
	
	// filter max 3 digits as Answer.. 
	static void printPermutationsTest2(String str, String answer)
    {
		if (answer.length() == 3) {
            System.out.print(answer + " ");
            return;
        }
		boolean[] freq = new boolean[150];
		for (int i = 0; i < str.length(); i++) {
        	char ch = str.charAt(i);
        	String ros = str.substring(0, i) + str.substring(i + 1);
        	if(freq[ch] == false)
        		printPermutationsTest2(ros, answer + ch);
        	freq[ch] = true;
        }
    }
	
	// filter max 3 digits as Answer.. 
	static void printPermutationsTest3(String str, String answer)
    {
		if (str.length() == 1) {
            System.out.print(answer + " ");
            return;
        }
		for (int i = 0; i < str.length(); i++) {
        	char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutationsTest3(ros, answer + ch);
        }
    }
	
	// filter max 3 digits as Answer.. 
	static void printPermutationsTest(String str, String answer)
    {
		if (answer.length() > 2) {
            System.out.print(answer + " ");
            return;
        }
		for (int i = 0; i < str.length(); i++) {
        	char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutationsTest(ros, answer + ch);
        }
    }
	
	
	// o(n2)
	static void printDistinctPermution(String str, String answer)
    {
		if (str.length() == 0) {
            System.out.print(answer + " ");
            return;
        }
		boolean[] freq = new boolean[150];
		for (int i = 0; i < str.length(); i++) {
        	char ch = str.charAt(i);
        	
            String ros = str.substring(0, i) +
                        str.substring(i + 1);

            if (freq[ch] == false)
            	printDistinctPermution(ros, answer + ch);
            freq[ch] = true;
        }
    }
	
	// o(n2)
	static void printPermution(String str, String answer)
    {
		if (str.length() == 0) {
            System.out.print(answer + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
        	String remaining = str.substring(0, i) + str.substring(i + 1);
        	printPermution(remaining, answer + str.charAt(i));
        }
    }
	
	// o(n!)
	static void printPermution2(String str, int start, int len)
    {
		int i;
		if (start == len) {
            System.out.print(str + " ");
            return;
        }
        for (i = start; i < len; i++) {
        	str = swap(str, start, i);
        	printPermution2(str, start+1, len);
        	str = swap(str, start, i);
        }
    }
	static String swap(String s, int fromPos, int toPos) {
		StringBuilder strBuilder = new StringBuilder(s);
		char c = s.charAt(fromPos);
		strBuilder.setCharAt(fromPos, s.charAt(toPos));
		strBuilder.setCharAt(toPos, c);
		return strBuilder.toString();
	}
}
