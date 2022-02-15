package patterns.twopinters;

import java.util.Arrays;
import java.util.Enumeration;

/*
* https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
* Given an integer n, return any array containing n unique integers such that they add up to 0.
Example 1:
Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
*
Example 2:
Input: n = 3
Output: [-1,0,1]
* Example 3:
Input: n = 1
Output: [0]
* */
public class SumZeroArray {
    public static void main(String[] args) {
        Arrays.stream(sumZero(6)).forEach(num -> System.out.println(num));
    }
    public static int[] sumZero(int n){
        int[] result = new int[n];
        int left = 0;
        int right = n -1;
        int start = 1;
        while (left<right){
            result[left++] = start;
            result[right--] = -start;
            start++;
        }
        return result;
    }
}
