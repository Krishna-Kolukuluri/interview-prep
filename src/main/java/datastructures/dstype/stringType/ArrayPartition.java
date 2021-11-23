package datastructures.dstype.stringType;

import java.util.Arrays;

/*
Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

* */
public class ArrayPartition {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2};
        arrayPairSum(nums);
    }
    public static int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int sum = 0;
        for(int index=0; index<nums.length-1;index +=2){
            sum += nums[index];
        }
        return sum;
    }
}
