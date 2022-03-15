package patterns.general;

/*
* https://leetcode.com/problems/kth-missing-positive-number/
* Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
Find the kth positive integer that is missing from this array.
*
Example 1:
Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
*
Example 2:
Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
* */
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
        arr = new int[]{1,2,3,4};
        System.out.println(findKthPositive(arr, 2));
    }

    /*
    * TC: O(len)
    *  SC: O(1)
    * */
    public static int findKthPositive(int[] arr, int k){
        int len = arr[arr.length -1];
        int j = 0;
        int missingCount = 0;
        for(int i=1;i<=len;i++){
            if(arr[j] != i){
                missingCount++;
            }else{
                j++;
            }
            if(missingCount == k){
                return i;
            }
        }
        return len + k - missingCount;
    }
}
