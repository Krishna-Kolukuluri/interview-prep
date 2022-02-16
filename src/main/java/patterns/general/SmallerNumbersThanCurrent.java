package patterns.general;

import java.util.Arrays;

/*
* https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
* Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each
* nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.
* Example 2:
Input: nums = [6,5,4,8]
Output: [2,1,0,3]
*
Example 3:
Input: nums = [7,7,7,7]
Output: [0,0,0,0]
*
Constraints:
2 <= nums.length <= 500
0 <= nums[i] <= 100
*
* */
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,4,8};
        Arrays.stream(smallerNumbersThanCurrent(nums)).forEach(num -> System.out.println(num));
        nums = new int[]{7,7,7,7};
        Arrays.stream(smallerNumbersThanCurrent(nums)).forEach(num -> System.out.println(num));
    }

    /*
    * TC: O(N)
    * SC: O(1)
    * */
    public static int[] smallerNumbersThanCurrent(int[] nums){
        int[] bucket = new int[102];
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]+1]++;
        }
        for(int i=1;i<102;i++){
            bucket[i] += bucket[i-1];
        }
        for(int i = 0; i<nums.length;i++){
            nums[i] = bucket[nums[i]];
        }
        return nums;
    }
}
