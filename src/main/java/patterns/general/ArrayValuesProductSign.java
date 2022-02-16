package patterns.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* https://leetcode.com/problems/sign-of-the-product-of-an-array/
* There is a function signFunc(x) that returns:
1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.
Return signFunc(product).
*
* */
public class ArrayValuesProductSign {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,3,2,1};
        System.out.println(arraySign(nums));
        nums = new int[]{1,5,0,2,-3};
        System.out.println(arraySign(nums));
        nums = new int[]{-1,1,-1,1,-1};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums){
        int sign = 1;
        for(int num: nums){
            if(num == 0){
                return 0;
            }
            if(num<0){
                sign = -sign;
            }
        }
        return sign;
    }
}
