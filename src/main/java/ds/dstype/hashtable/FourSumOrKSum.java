package ds.dstype.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement:
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.
* */
public class FourSumOrKSum {
    /*
    Time Complexity: O(n^{k - 1}), or O(n^3) for 4Sum. We have k - 2k−2 loops iterating over nn elements, and twoSum is O(n).
    Note that for k>2, sorting the array does not change the overall time complexity.
    Space Complexity: O(n) for the hash set. The space needed for the recursion will not exceed O(n).
    * */
    /*

* Approach 1: Two Pointers*
* Algorithm

We can implement k - 2 loops using a recursion. We will pass the starting point and k as the parameters. When k == 2,
we will call twoSum, terminating the recursion.

For the main function:

Sort the input array nums.
Call kSum with start = 0, k = 4, and target, and return the result.
For kSum function:

At the start of the kSum function, we will check three conditions:
Have we run out of numbers to choose from?
Is the smallest number remaining greater than target / k?
If so, then any k numbers we choose will be too large.
Is the largest number remaining smaller than target / k?
If so, then any k numbers we choose will be too small.
If any of these conditions is true, there is no need to continue as no combination of the remaining elements can sum to target.
If k equals 2, call twoSum and return the result.
Iterate i through the array from start:
If the current value is the same as the one before, skip it.
Recursively call kSum with start = i + 1, k = k - 1, and target - nums[i].
For each returned subset of values:
Include the current value nums[i] into subset.
Add subset to the result res.
Return the result res.
For twoSum function:

Set the low pointer lo to start, and high pointer hi to the last index.
While low pointer is smaller than high:
If the sum of nums[lo] and nums[hi] is less than target, increment lo.
Also increment lo if the value is the same as for lo - 1.
If the sum is greater than target, decrement hi.
Also decrement hi if the value is the same as for hi + 1.
Otherwise, we found a pair:
Add it to the result res.
Decrement hi and increment lo.
Return the result res.
    * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        int average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }
        return res;
    }
}
