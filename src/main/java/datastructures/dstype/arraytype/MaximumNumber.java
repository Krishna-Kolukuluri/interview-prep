package datastructures.dstype.arraytype;

import java.util.Arrays;

public class MaximumNumber {
    public static void main(String[] args) {

        int[] nums = new int[]{1,1,2};
        int max = thirdMaximumNumber(nums);
        System.out.println("Third Distinct Maximum ==>" + max);

//        int[] nums = new int[]{3,2,1};
//        int max = thirdMaximumNumber(nums);
//        System.out.println("Third Distinct Maximum ==>" + max);

    }

    static int thirdMaximumNumber(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        int idx = n - 1 , i , distinctCount = 0;
        while(idx >= 0)
        {
            distinctCount++;
            i = idx - 1;
            //to check all the values with same value as a[idx]
            while(i >= 0 && nums[i] == nums[idx])
                i--;
            //no third distinct element
            if(i == -1)
                return nums[n - 1];
            idx = i;
            //found 2 bigger elements before?
            if(distinctCount == 2)
                return nums[idx];
        }
        return -1;
    }
}
