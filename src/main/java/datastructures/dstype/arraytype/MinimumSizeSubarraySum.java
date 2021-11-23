package datastructures.dstype.arraytype;

import java.util.Arrays;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such
subarray, return 0 instead.
* */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int target = 213;
        int result = minSubArrayLen(213, nums);
        System.out.println(result);
    }
    public static int minSubArrayLen(int target, int[] nums){
        int minLen = Integer.MAX_VALUE;
        int leftIndex = 0;
        int sum = 0;
        for(int index=0;index<nums.length;index++){
            sum += nums[index];
            while(sum>=target){
                minLen = Math.min(minLen, index+1 -leftIndex);
                sum -=nums[leftIndex];
                leftIndex++;
            }
        }
        return (minLen == Integer.MAX_VALUE)?0:minLen;
    }
}
