package CommonProblems;

import java.util.Arrays;

/*
*
* https://leetcode.com/problems/3sum-closest/
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
* */
public class ThreeSumClose {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    /*
    * Initialize the minimum difference diff with a large value.
    Sort the input array nums.
    Iterate through the array:
    For the current position i, set lo to i + 1, and hi to the last index.
    While the lo pointer is smaller than hi:
    Set sum to nums[i] + nums[lo] + nums[hi].
    If the absolute difference between sum and target is smaller than the absolute value of diff:
    Set diff to target - sum.
    If sum is less than target, increment lo.
    Else, decrement hi.
    If diff is zero, break from the loop.
    Return the value of the closest triplet, which is target - diff.
    * */
    private static int threeSumClosest(int[] nums, int target){
        int diff = Integer.MAX_VALUE;
        int length = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<length && diff != 0;i++){
            int lo = i + 1;
            int hi = length - 1;
            while (lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(target - sum) < Math.abs(diff)){
                    diff = target - sum;
                }
                if(sum < target){
                    lo++;
                }
                else {
                    hi--;
                }
            }
        }
        return target - diff;
    }
    /*
    * Time Complexity: O(n^2). We have outer and inner loops, each going through nn elements.
    Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2). This is asymptotically equivalent to O(n^2)
    Space Complexity: from O(logn) to (n)O(n), depending on the implementation of the sorting algorithm.
    * */
}
