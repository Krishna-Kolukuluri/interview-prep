package patterns.general;

import java.util.Arrays;

/*
* https://leetcode.com/problems/shuffle-the-array/
* Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].
*
Example 1:
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
*
Example 2:
Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
*
Example 3:
Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]
* */
public class ShuffleArray {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        Arrays.stream(shuffle(nums, 4)).forEach(num-> System.out.println(num));

    }
    /*
    * TC: O(N/2)
    * SC: O(N)
    * */
    public static int[] shuffle(int[] nums, int n){
        int[] result = new int[2*n];
        int j =0;
        for(int i=0;i<n;i++){
            result[j++] = nums[i];
            result[j++] = nums[n+i];
        }
        return result;
    }

    // input : [x1 , x2, x3 , y1, y2, y3]
    /*
     * TC: O(N)
     * SC: O(1)
     * */
    public int[] shuffleInPlace(int[] nums, int n) {
        for(int i = 0; i < n; i++){
            nums[i] += nums[n + i] * 10000;
        }
        // at this point nums = [x1y1, x2y2, x3y3, y1, y2, y3].

        // we fill in the array values from the end, so as not to overwrite the calculated numbers in previous step
        // at the end of one iteration nums will be [x1y1, x2y2, x3y3, y1, x3, y3 ]
        for(int i = n - 1; i >= 0; i--){
            nums[2 * i + 1] = nums[i] / 10000;
            nums[2 * i] = nums[i] % 10000;
        }

        return nums;
    }
}
