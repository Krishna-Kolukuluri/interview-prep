package datastructures.dstype.hashtable;

import java.util.*;

/*
Problem Statement:
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
* */
/*
ThreeSum is extension of TwoSum with two pointer approach, sort the array if its already not sorted. Here target is '0'.
* */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
    }
    /*
    Complexity Analysis
    Time Complexity: O(n^2)
    twoSumII is O(n), and we call it n times.
    Sorting the array takes O(nlogn), so overall complexity is O(nlogn + n^2).
    This is asymptotically equivalent to O(n^2)
    Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting
    algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.
    * */
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for(int idx=0;idx<nums.length && nums[idx]<=0;idx++){
            if(idx == 0 || nums[idx - 1] != nums[idx]){
                    TwoSumII(nums, idx, results);
            }
        }
        return results;
    }
    public static void TwoSumII(int[] nums, int idx, List<List<Integer>> result){
        int lo = idx + 1;
        int hi = nums.length - 1;
        while (lo<hi){
            int sum = nums[idx] + nums[lo] + nums[hi];
            if(sum<0){
                lo++;
            }else if(sum>0){
                hi--;
            }else {
                result.add(Arrays.asList(nums[idx], nums[lo], nums[hi]));
                lo++;  hi--;
                while (lo < hi && nums[lo] == nums[lo - 1]){
                    lo++;
                }
            }
        }
    }

    //HashSet approach
    public List<List<Integer>> threeSumHashSet(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                //Skipping next element to avoid duplicate lists(triplets) for same input element value
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }


    //Without modifying input array and not allowed to duplicate array due to space constraints
    public List<List<Integer>> threeSumNoSort(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}
