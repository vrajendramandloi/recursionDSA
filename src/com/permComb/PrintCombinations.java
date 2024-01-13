package com.permComb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PrintCombinations {
	public static void main(String[] args) {
		String s = "abc1234";
		printCombination(s);
		System.out.println();
		System.out.println("======================================================================================");
		int arr[] = {1, 2, 3, 4, 5};
		printCombinationArray(arr);
		printCombinationArrayRec(arr, 0, new ArrayList<Integer>());
		System.out.println(output.toString());
		printCombinationArrayRec2(arr, 0, new int[3], 0);
		System.out.println();
		System.out.println();
		int arr2[] = {1, 2, 3, 4, 5,6,7,8,9,10,12,15,16};
		//printCombinationArrayRec2(arr2, 0, new int[4], 0);
		System.out.println();
		System.out.println();
		int arr3[] = {1, 2, 2, 1, 5,5,7,7,7,8,8,8,8};
		Arrays.sort(arr3);
		printCombinationArrayRecNonDuplicate(arr3, 0, new int[3], 0);
		System.out.println();
		System.out.println();
		int arr4[] = {1, 2, 5, 7 ,8};
		Arrays.sort(arr3);
		printCombinationArrayRecWithDuplicate(arr4, 0, new ArrayList<Integer>(), 15);
	}
	
	public static void printCombinationArrayRecWithDuplicate(int[] arr, int start, List<Integer> currentList , int target) {
		if(target == 0 && currentList.size() == 3) {
			System.out.print(currentList.toString()+ "  ");
			return;
		}
		if(target < 0 || currentList.size() == 3) return;
		for(int i=start; i<arr.length; i++) {
			currentList.add(arr[i]);
			printCombinationArrayRecWithDuplicate(arr, i, currentList, target - arr[i]);
			currentList.remove(currentList.size() - 1);
		}
	}
	
	public static void printCombinationArrayRecNonDuplicate(int[] arr, int start, int[] outputData, int index) {
		if(index == outputData.length) {
			System.out.print(Arrays.toString(outputData) + "  ");
			return;
		}
		for(int i=start; i<arr.length; i++) {
			int item = arr[i];
			if(IntStream.of(outputData).anyMatch(x -> x == item)) continue;
			outputData[index]=item;
			printCombinationArrayRecNonDuplicate(arr, i+1, outputData, index+1);
		}
	}
	
	static String combination = ""; 
	public static void printCombination(String str) {
		for(int i=0;i<str.length(); i++) {
			combination += str.charAt(i);
			if(combination.length() < 3) {
				System.out.print(combination+" = ");
				printCombination(str);
			}
			combination = combination.substring(0, combination.length() - 1);
		}
	}
	
	public static void printCombinationArray(int[] arr) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		
		for(int n : arr) {
			int len = res.size();
			for(int i=0;i<len; i++) {
				List<Integer> temp = new ArrayList<Integer>(res.get(i));
				temp.add(n);
				res.add(temp);
			}
		}
		System.out.println(res.toString());
	}
	
	static List<List<Integer>> output = new ArrayList<List<Integer>>();
	public static void printCombinationArrayRec(int[] arr, int start, List<Integer> outputData) {
		if(outputData.size() == 3) {
			output.add(new ArrayList<Integer>(outputData));
			return;
		}
		for(int i=start; i<arr.length; i++) {
			outputData.add(arr[i]);
			printCombinationArrayRec(arr, i+1, outputData);
			outputData.remove(outputData.size() -1);
		}
	}
	
	public static void printCombinationArrayRec2(int[] arr, int start, int[] outputData, int index) {
		if(index == outputData.length) {
			System.out.print(Arrays.toString(outputData) + "  ");
			return;
		}
		for(int i=start; i<arr.length; i++) {
			outputData[index]=arr[i];
			printCombinationArrayRec2(arr, i+1, outputData, index+1);
			//--index;
		}
	}
	
	
}
