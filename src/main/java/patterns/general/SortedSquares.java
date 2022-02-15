package patterns.general;

import java.util.Arrays;

/*
* https://leetcode.com/problems/squares-of-a-sorted-array/
* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
*
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
*
Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
* */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        Arrays.stream(sortedSquares(nums)).forEach(num -> System.out.println(num));

    }
    public static int[] sortedSquares(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        int left =0;
        int right = n -1;
        for(int i = n-1; i>=0; i--){
            int square ;
            if(Math.abs(nums[left])<Math.abs(nums[right])){
                square = nums[right];
                right--;
            }
            else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}
