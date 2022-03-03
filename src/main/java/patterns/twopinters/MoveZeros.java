package patterns.twopinters;

import java.util.Arrays;

/*
* https://leetcode.com/problems/move-zeroes/
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
*
* Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*
* Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?
* */
public class MoveZeros {
    /*
    * SC: O(1)
    * TC: O(N)
    * */
    public static int[] moveZeros(int[] nums){
        int  j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(i!=j){
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        Arrays.stream(moveZeros(nums)).forEach(num -> System.out.println(num));
        nums = new int[]{5,0,6,10,1,0,3,12};
        Arrays.stream(moveZeros(nums)).forEach(num -> System.out.println(num));
    }
}
