package datastructures.dstype.hashtable;

import java.util.HashMap;
/*
https://leetcode.com/problems/two-sum/

Problem Statement:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
*
Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
* */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] indexes = twoNumSumToTarget(nums, 9);
    }
    //Best possible solution with O(n) time and space complexity.
    public static int[] twoNumSumToTarget(int[] nums, int target){
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for(int index=0;index<nums.length; index++){
            //Add nums[index] as key and actual index as value in HashMap for comparison
            int tempNum = target - nums[index];
            if(numsMap.containsKey(tempNum)){
                return new int[]{numsMap.get(tempNum), index };
            }
            numsMap.put(nums[index], index);
        }
        return new int[]{};
    }
    /*
    Complexity Analysis
    Time complexity: O(n). We traverse the list containing n elements only once.
    Each lookup in the table costs only O(1) time.
    Space complexity: O(n). The extra space required depends on the number of items stored in the hash table,
    which stores at most n elements.
    * */
}
