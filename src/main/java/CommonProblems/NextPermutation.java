package CommonProblems;

import java.util.Arrays;

/*
*  https://leetcode.com/problems/next-permutation/
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally,
if all the permutations of the array are sorted in one container according to their lexicographical order, then the next
permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible,
the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.
*
* */
/*
* Complexity Analysis:
    Time complexity : O(n). In worst case, only two scans of the whole array are needed.
    Space complexity : O(1). No extra space is used. In place replacements are done.
* */
public class NextPermutation {
    public static void main(String[] args) {
        Arrays.stream(nextPermutation(new int[]{1,2,3})).forEach(num -> System.out.println(num));
    }
    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
