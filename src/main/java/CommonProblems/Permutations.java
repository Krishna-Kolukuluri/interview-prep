package CommonProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.com/problems/permutations/
* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
*
* Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
* Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
* Example 3:
Input: nums = [1]
Output: [[1]]
* */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
    public static void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }
    /*
    * Time complexity : N!/(N-k)!
    * Space complexity : \mathcal{O}(N!)O(N!) since one has to keep N! solutions.
    * */

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
