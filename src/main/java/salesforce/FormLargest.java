package salesforce;

import java.util.Arrays;
import java.util.Comparator;

/**
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:
    Input: nums = [10,2]
    Output: "210"

Example 2:
    Input: nums = [3,30,34,5,9]
    Output: "9534330"
    
    First, we convert each integer to a string. Then, we sort the array of strings.

While it might be tempting to simply sort the numbers in descending order, this causes problems for sets of numbers with 
the same leading digit. For example, sorting the problem example in descending order would produce the number 95343039534303, 
while the correct answer can be achieved by transposing the 33 and the 3030. Therefore, for each pairwise comparison during 
the sort, we compare the numbers achieved by concatenating the pair in both orders. We can prove that this sorts into the proper order as follows:

Assume that (without loss of generality), for some pair of integers aa and bb, our comparator dictates that aa should precede bb in sorted order. 
This means that a\frown b > b\frown aa⌢b>b⌢a (where \frown⌢ represents concatenation). For the sort to produce an incorrect ordering, there must be 
some cc for which bb precedes cc and cc precedes aa. This is a contradiction because a\frown b > b\frown aa⌢b>b⌢a and b\frown c > c\frown bb⌢c>c⌢b 
implies a\frown c > c\frown aa⌢c>c⌢a. In other words, our custom comparator preserves transitivity, so the sort is correct.

Once the array is sorted, the most "signficant" number will be at the front. There is a minor edge case that comes up when the array consists of only zeroes, so if the most significant number is 00, we can simply return 00. Otherwise, we build a string out of the sorted array and return it.
 */
public class FormLargest {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}
