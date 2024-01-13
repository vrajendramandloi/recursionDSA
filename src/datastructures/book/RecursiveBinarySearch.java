package datastructures.book;

public class RecursiveBinarySearch {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int searchStr = -1;
		System.out.println(recursiveBinarySearch(arr, searchStr, 0, arr.length-1));
	}
	
	static boolean recursiveBinarySearch(int[] arr, int searchNum, int min, int max) {
		if(min>max) {
			return false;
		}
		
		int mid = (min + max) /2;
		if(arr[mid] == searchNum) return true;
		if(arr[mid] > searchNum) {
			return recursiveBinarySearch(arr, searchNum, min, mid-1);
		} else {
			return recursiveBinarySearch(arr, searchNum, mid+1, max);
		}
	}
}
