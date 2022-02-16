package patterns.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
* https://leetcode.com/problems/next-greater-element-i/
* The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element
of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
*
* Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -
*
Constraints:
1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.
* */
public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
        Arrays.stream(nextGreaterElement(nums1, nums2)).forEach(num -> System.out.println(num));
    }
    /*
    *
    * Complexity Analysis:
        Let nn and mm represent the length of the nums2 and nums1 array respectively.
        Time complexity: O(n). The entire nums2 array (of size n) is scanned only once. Each of the stack's n
        elements are pushed and popped exactly once. The nums1nums1 array is also scanned only once. All together this
        requires O(n+n+m) time. Since nums1nums1 must be a subset of nums2, we know m must be less
        than or equal to nn. Therefore, the time complexity can be simplified to O(n).
        Space complexity: O(n). map will store nn key-value pairs while stack will contain at most n elements at any given time
    * */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        int n = nums1.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length;i++){
            while (!stack.isEmpty() && nums2[i]>stack.peek()){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        for(int i=0; i<nums1.length;i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
