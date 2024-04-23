package datastructures.book;

import java.util.Arrays;

public class SystemArrayCopyExample {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};
        System.arraycopy(arr2, 1, arr1, 3, 2);
        System.out.println(Arrays.toString(arr1));
    }
}
