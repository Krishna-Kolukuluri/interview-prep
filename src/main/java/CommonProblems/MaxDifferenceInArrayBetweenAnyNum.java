package CommonProblems;
/*
* Given an array of integers, find the maximum difference of any 2 numbers.
 * */
public class MaxDifferenceInArrayBetweenAnyNum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 10, 6, 4, 8, 1};
        System.out.println(getMaxDifference(nums));
    }

    public static int getMaxDifference(int[] nums){
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int num: nums){
            minVal = Math.min(num, minVal);
            maxVal = Math.max(num, maxVal);
        }
        return maxVal - minVal;
    }
}
