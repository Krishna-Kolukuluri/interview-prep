package CommonProblems;
/*
*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
*
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
*  */
//Space and Time Complexity: O(M + N) where M is length of nums1 and N is length of nums2.
public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeTwoSortedArray(nums1, nums2);
        int n = mergedArray.length;
        // TODO: check index here
        if (n % 2 == 0) {
            return (mergedArray[(n-1) / 2] + mergedArray[n/2]) / 2.0;
        } else {
            return mergedArray[n / 2];
        }
    }

    private static int[] mergeTwoSortedArray(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int idx = 0;

        while (i < nums1.length || j < nums2.length) {
            int curr1 = i >= nums1.length ? Integer.MAX_VALUE : nums1[i];
            int curr2 = j >= nums2.length ? Integer.MAX_VALUE : nums2[j];
            if (curr1 < curr2) {
                mergedArray[idx++] = curr1;
                ++i;
            } else {
                mergedArray[idx++] = curr2;
                ++j;
            }
        }
        return mergedArray;
    }
}
