package CommonProblems;

import java.util.Arrays;

/*
Remove duplicates numbers from an unsorted array and store them in BigO(n) time.
Find unique list of integers from given a list of integers
* */
public class RemoveDuplicatesFromUnsortedList {

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2,6,3,6,4};
        for(int num: removeDuplicates(nums)){
            System.out.println(num);
        }
    }

    public static int[] removeDuplicates(int[] nums){
        int n = nums.length;
        if(n ==0 || n == 1){
            return nums;
        }
        int i , j , k;
        for(i=0; i<n;i++){
            j = i + 1;
            while (j<n){
                if(nums[i] == nums[j]){
                    k = j;
                    while (k<n-1){
                        nums[k] = nums[k+1];
                        k++;
                    }
                    n--;
                }else{
                    j++;
                }
            }
        }
        return Arrays.copyOfRange(nums, 0, n);
    }
}
