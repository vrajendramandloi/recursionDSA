package heretech.classroomLecture;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MaxSumOfCards {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,1};
		MaxSumOfCards m1 = new MaxSumOfCards();
		m1.findmaximum(arr, 0, arr.length, new ArrayList<>());
	}
	
	public int findmaximum(int[] arr, int left, int right, List<Integer> picked) {
		if(picked.size() == 3) {
			return picked.stream().mapToInt(Integer::intValue).sum();
		}
		if(arr[left]>arr[right]) {
			picked.add(arr[left]);
			return findmaximum(arr, left+1, right, picked);
		} else if(arr[left]>arr[right]) {
			picked.add(arr[right]);
			return findmaximum(arr, left, right-1, picked);
		}
		return 0;
	}
}
