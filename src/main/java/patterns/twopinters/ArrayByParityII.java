package patterns.twopinters;

import java.util.Arrays;

/*
*
* Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
Return any answer array that satisfies this condition.
*
Example 1:
Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
*
Example 2:
Input: nums = [2,3]
Output: [2,3]
*
Constraints:
2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
*
* */
public class ArrayByParityII {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,5,7};
        Arrays.stream(sortArrayByParity(nums)).forEach(num -> System.out.println(num));
    }

    /*
    * Complexity Analysis:
        Time Complexity: O(N), where N is the length of A.
        Space Complexity: O(1).
    * */
    public static int[] sortArrayByParity(int[] nums){
        int j = 1;
        //Even slice loop
        for (int i = 0; i < nums.length; i += 2)
            //In even slice, if odd number found then find even number in odd number slice for swapping
            if (nums[i] % 2 == 1) {
                //Odd slice loop
                while (nums[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        return nums;
    }
}
