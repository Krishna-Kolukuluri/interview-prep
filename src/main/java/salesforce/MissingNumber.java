package salesforce;

import java.util.*;

public class MissingNumber {
    /**
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

            Example 1:
            Input: nums = [3,0,1]
            Output: 2
            Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
            
            Time complexity : \mathcal{O}(n)O(n)
            **/

    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
