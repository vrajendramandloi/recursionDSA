package leetcodepractice;

public class SumTwo {
    public static void main(String[] args) {
        SumTwo a1 = new SumTwo();
        int[] nums = new int[] {3,2,4};
        a1.twoSum(nums, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) return new int[]{};
        if(nums.length == 1 && nums[0] == target) return new int[]{0};
        int startPoint = 0;
        int i=startPoint;
        while(i<nums.length) {
            if(i == nums.length-1) {
                ++ startPoint;
                i=startPoint;
                continue;
            }
            i++;
            int sum  = nums[startPoint] + nums[i];
            if( sum == target ) {
                return new int[]{startPoint, i};
            }
        }
        return new int[]{};
    }
}
