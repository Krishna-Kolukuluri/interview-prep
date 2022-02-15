package patterns.general;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/number-of-good-pairs/
* Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.
*
Example 1:
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
*
Example 2:
Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
*
Example 3:
Input: nums = [1,2,3]
Output: 0
*
* */
public class GoodPairs {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
        nums = new int[]{1,1,1,1};
        System.out.println(numIdenticalPairs(nums));

    }
    public static int numIdenticalPairs(int[] nums){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            int numCount = entry.getValue();
            count +=  numCount * (numCount -1) / 2;
        }
        return count;
    }
}
