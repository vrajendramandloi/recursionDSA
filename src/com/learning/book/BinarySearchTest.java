package datastructures.book;

public class BinarySearchTest {
	
	
	public static void main(String[] args) {
		int arr[] = {0, 1,2,3,4,5, 6, 7, 8, 9, 10, 11, 12, 13};
		BinarySearchTest b1 = new BinarySearchTest();
		b1.binarySearch(arr, 5);
		b1.binarySearch(arr, 0);
		b1.binarySearch(arr, 13);
		System.out.println("Binary Search Algo");
		b1.recursiveBinarySearch(arr, 5, 0, arr.length-1);
		b1.recursiveBinarySearch(arr, 0, 0, arr.length-1);
		b1.recursiveBinarySearch(arr, 13, 0, arr.length-1);
		System.out.println("Binary Search Algo");
		b1.recursiveBinarySearchNonReturn(arr, 5, 0, arr.length-1);
		b1.recursiveBinarySearchNonReturn(arr, 0, 0, arr.length-1);
		b1.recursiveBinarySearchNonReturn(arr, 13, 0, arr.length-1);
	}
	
	public int recursiveBinarySearch(int[] arr, int element, int min, int max) {
		while(max>=min) {
			int mid = min+ (max - min ) / 2;
			if(arr[mid] == element) {
				System.out.println(element + " Recursive Element Found at position "+mid);
				return mid;
			}
			return (arr[mid] > element)  ? recursiveBinarySearch(arr, element, min, mid -1) : recursiveBinarySearch(arr, element, mid + 1, max);
		}
		return -1;
	}
	
	public void recursiveBinarySearchNonReturn(int[] arr, int element, int min, int max) {
		while(min<=max) {
			int mid = min+ (max - min ) / 2;
			if(arr[mid] == element) {
				System.out.println(element + " Recursive Element Found at position "+mid);
				return;
			}
			if (arr[mid] > element) {
				recursiveBinarySearchNonReturn(arr, element, min, mid -1);
			} else {
				recursiveBinarySearchNonReturn(arr, element, mid + 1, max);
			}
			return;
		}
	}
	
	
	
	public void binarySearch(int[] arr, int element) {
		int min = 0;
		int max = arr.length-1;
		while(min <= max) {
			//int mid = min + ( max - min ) / 2;
			int mid = ( max + min ) / 2;
			if(arr[mid] == element) {
				System.out.println(element + " Element Found at position "+mid);
				break;
			}
			if(arr[mid] > element) {
				max = mid-1;
			} else {
				min = mid + 1;
			}
		}
	}
	
	
}
