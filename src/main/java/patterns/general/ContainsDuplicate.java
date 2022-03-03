package patterns.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* https://leetcode.com/problems/contains-duplicate/
* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
* element is distinct.
*
* Example 1:
Input: nums = [1,2,3,1]
Output: true
*
* Example 2:
Input: nums = [1,2,3,4]
Output: false
*
* Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
* */
public class ContainsDuplicate {
    /*
    * TC: O(N)
    * SC: O(N)
    * */
    public static boolean containsDuplicates(int[] nums){
        Set<Integer> uniqueNums = new HashSet<>();
        for(int num: nums){
            if(uniqueNums.contains(num)){
                return true;
            }else {
                uniqueNums.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicates(nums));
        nums = new int[]{1,2,3,4};
        System.out.println(containsDuplicates(nums));
    }
}
