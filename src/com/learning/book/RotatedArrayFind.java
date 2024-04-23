package datastructures.book;

public class RotatedArrayFind {
	
	public static void main(String[] args) {
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		//           0  1  2  3  4  5   6  7  8
		System.out.println(findIndexOfMaxElement(arr, 0, arr.length-1));
		arr = new int[]{4, 5, 6, 7, 8, 9, 10};
		//              0  1  2  3  4  5   6
		System.out.println(findIndexOfMaxElement(arr, 0, arr.length-1));
		arr = new int[]{10,1, 2, 3};
		//              0  1  2  3 
		System.out.println(findIndexOfMaxElement(arr, 0, arr.length-1));
		
		System.out.println("Find Max Index : ");
		arr = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
		findPositionOfElementinRotatedArray(arr, 2);
		arr = new int[]{5, 6, 7, 8, 9, 10, 1, 2};
		findPositionOfElementinRotatedArray(arr, 2);
		arr = new int[]{5, 2, 3};
		findPositionOfElementinRotatedArray(arr, 5);
		
	}
	
	static int findIndexOfMaxElement(int arr[], int low, int high)
    {
        while(low<=high) {
        	if(low==high) return low;
        	int mid = (low + high) / 2;
	        if ( arr[mid] > arr[mid + 1])
	            return mid;
	        if ( arr[mid-1] > arr[mid])
	            return (mid - 1);
	        
	        if (arr[low] >= arr[mid])
	            return findIndexOfMaxElement(arr, low, mid - 1);
	        return findIndexOfMaxElement(arr, mid + 1, high);
        }
        return -1;
    }
	
	static void findPositionOfElementinRotatedArray(int[] arr, int element) {
		int maxIndex = findIndexOfMaxElement(arr, 0, arr.length-1);
		if(maxIndex == -1) recursiveBinarySearch(arr, element, 0, arr.length-1);
		if(arr[maxIndex] == element) {
			System.out.println(element +" Index of Max Index "+ maxIndex);
			return;
		}
		if(arr[maxIndex] > element) {
			recursiveBinarySearch(arr, element, maxIndex+1, arr.length-1);
		} else {
			recursiveBinarySearch(arr, element, 0, maxIndex-1);
		}
	}
	
	public static void recursiveBinarySearch(int[] arr, int element, int min, int max) {
		while(min <= max) {
			int mid = (max + min ) / 2;
			if(arr[mid] == element) {
				System.out.println(element + " Element Found at position "+mid);
				return;
			}
			if(arr[mid] > element) {
				recursiveBinarySearch(arr, element, min, mid -1);
			} else  {
				recursiveBinarySearch(arr, element, mid + 1, max);
			}
			return;
		}
	}
	
}
