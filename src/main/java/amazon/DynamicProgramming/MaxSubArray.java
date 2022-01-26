package amazon.DynamicProgramming;

public class MaxSubArray {
    
    public static void main(String args[]) {
        maxSubArray(new int[]{ 1,2,3,3,4,5,6,7,8,9,10 });
    }
    public static int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }
        System.out.println();
        System.out.println(maxSubarray);
        return maxSubarray;
    }

}
