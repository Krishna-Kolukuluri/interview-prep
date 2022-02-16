package patterns.twopinters;

import java.util.*;

/*
* https://leetcode.com/problems/intersection-of-two-arrays/
* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
* unique, and you may return the result in any order.
* Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
*
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
*
Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
*
* */
public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        Arrays.stream(intersection(nums1, nums2)).forEach(num -> System.out.println(num));
    }
    /*
    *Complexity Analysis:
        Time complexity : O(n+m) in the average case and O(n×m) in the worst case when load factor is high enough.
        Space complexity : O(n+m) in the worst case when all elements in the arrays are different.
    *
    * */
    public static int[] intersection(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        Set<Integer> vals = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        int[] longer = nums2;
        int[] shorter = nums1;

        if(n1>n2){
            longer = nums1;
            shorter = nums2;
        }
        for(int num: longer){
            vals.add(num);
        }

        for(int num: shorter){
            if(vals.contains(num)){
                result.add(num);
            }
        }
        int[] commonNums = new int[result.size()];
        int idx = 0;
        for(int num: result){
            commonNums[idx] = num;
            idx++;
        }
        //return result.stream().mapToInt(num-> num).toArray();
        return commonNums;
    }
}
