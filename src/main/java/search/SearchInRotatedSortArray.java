package search;
/*
* https://leetcode.com/problems/search-in-rotated-sorted-array/
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such
that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
*
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
*
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
* */
public class SearchInRotatedSortArray {

    /*
    * The problem is to implement a search in O(logN) time that gives an idea to use a binary search.
    * */

    /*
    * Complexity Analysis:
        Time complexity: O(logN).
        Space complexity: O(1)
    * */
    /*
    * Binary search:
    The problem is to implement a search in O(logN) time that gives an idea to use a binary search.
    The algorithm is quite straightforward :
    Find a rotation index rotation_index, i.e. index of the smallest element in the array. Binary search works just perfect here.
    rotation_index splits array in two parts. Compare nums[0] and target to identify in which part one has to look for target.
    Perform a binary search in the chosen part of the array.
    * */
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
