package CommonProblems;

import java.util.HashSet;
import java.util.Set;

/*
* https://leetcode.com/problems/single-number/solution/
* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
* You must implement a solution with a linear runtime complexity and use only constant extra space.
* Example 1:
Input: nums = [2,2,1]
Output: 1
*
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
*
Example 3:
Input: nums = [1]
Output: 1
*
Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
*
* */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumberConstantSpace(nums));
    }
    /*
    * TC : O(N)
    * SC: O(N) -> unique elements in input array
    * */
    public static int singleNumberLinearSpace(int[] nums){
        Set<Integer> uniqueNums = new HashSet<>();
        int sum = 0;
        int sumWithDuplicates = 0;
        for(Integer num:nums){
            if(!uniqueNums.contains(num)){
                sum += num;
                uniqueNums.add(num);
            }
            sumWithDuplicates += num;
        }
        //2 * (1+2+3+4) - (1+1+2+2+3+3+4) = (1+1+2+2+3+3+4+4) - (1+1+2+2+3+3+4) = 4
        return 2 * sum - sumWithDuplicates;
    }

    /*
    * TC: O(N)
    * SC: O(1)
    * For constant space bit manipulation is the only option
    * XOR
    * Concept:
        If we take XOR of zero and some bit, it will return that bit
        a ⊕ 0 = a
        If we take XOR of two same bits, it will return 0
        a ⊕ a = 0
        a ⊕ b ⊕ a = (a ⊕ a) ⊕ b = 0 ⊕ b = b
        So we can XOR all bits together to find the unique number.
    * */
    public static int singleNumberConstantSpace(int[] nums){
        int zero = 0;
        for(int num: nums){
            zero = zero^num;
        }
        return zero;
    }
}
