package salesforce;

import java.util.*;
/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, 
 * i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }
    static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }

    public static List<List> threeSumAnother(int[] nums) {
        Set<List> ans = new HashSet<>();
        for (int i=0; i<nums.length-2; i++) {
            Set targetOccur = new HashSet<>();
            int target = -nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (targetOccur.contains(target - nums[j])) {
                    //        Answer Found/ 
                    final List triplet = Arrays.asList(nums[i], nums[j], target-nums[j]);
                    Collections.sort(triplet);
                    ans.add(triplet);
                } else {
                    targetOccur.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    
    public static void main(String args[]){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.size());
        List<List> res = threeSumAnother(nums);
        System.out.println(res.size());
        
    }
}
