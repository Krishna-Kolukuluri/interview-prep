package patterns.general;

import java.util.Arrays;

/*
* https://leetcode.com/problems/maximum-product-of-three-numbers/
* Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
*
Example 1:
Input: nums = [1,2,3]
Output: 6
*
Example 2:
Input: nums = [1,2,3,4]
Output: 24
*
Example 3:
Input: nums = [-1,-2,-3]
Output: -6
* */
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(maximumProduct(nums));
    }

    /*
    *
    * Complexity Analysis:
        Time complexity : O(nlogn). Sorting the nums array takes nlogn time.
        Space complexity : O(logn). Sorting takes O(logn) space.
    * */
    public static int maximumProduct(int[] nums){
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        return  Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
