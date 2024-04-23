package leetcodepractice;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray m1 = new MergeSortedArray();
        int[] arr1 = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};
        m1.merge(arr1, 3, arr2, 3);
        System.out.println("TestCase 1: "+Arrays.toString(arr1));

        arr1 = new int[]{1};
        arr2 = new int[]{};
        m1.merge(arr1, 1, arr2, 0);
        System.out.println("TestCase 2: "+Arrays.toString(arr1));

        arr1 = new int[]{0};
        arr2 = new int[]{1};
        m1.merge(arr1, 0, arr2, 1);
        System.out.println("TestCase 3: "+Arrays.toString(arr1));

        arr1 = new int[]{1,0};
        arr2 = new int[]{2};
        m1.merge(arr1, 1, arr2, 1);
        System.out.println("TestCase 4: "+Arrays.toString(arr1));

        arr1 = new int[]{-1,0,1,1,0,0,0,0,0};
        arr2 = new int[]{-1,0,2,2,3};
        m1.merge(arr1, 4, arr2, 5);
        System.out.println("TestCase 5: "+Arrays.toString(arr1));

        arr1 = new int[]{2,0};
        arr2 = new int[]{1};
        m1.merge(arr1, 1, arr2, 1);
        System.out.println("TestCase 6: "+Arrays.toString(arr1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int secondArrayCount = 0;
        if(m<1) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if(n>=1) {
            for (int i = 0; i < nums1.length; i++) {
                if (secondArrayCount<nums2.length && nums2[secondArrayCount] < nums1[i]) {
                    System.arraycopy(nums1, i, nums1, i + 1, nums1.length - i - 1);
                    nums1[i] = nums2[secondArrayCount];
                    secondArrayCount++;
                    m++;
                }
                if (i > m - 1) {
                    System.arraycopy(nums2, secondArrayCount, nums1, i, n - secondArrayCount);
                }
            }
        }
    }
}
