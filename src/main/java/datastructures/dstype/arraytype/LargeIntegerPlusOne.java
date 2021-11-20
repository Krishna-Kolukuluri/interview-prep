package datastructures.dstype.arraytype;

import java.util.ArrayList;
import java.util.List;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the
integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer
does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
* */

public class LargeIntegerPlusOne {
    public static void main(String[] args){
        int[] result = plusOne(new int[]{1,2,3});
        System.out.println(result);
        result = plusOne(new int[]{9,9,9});
        System.out.println(result);
    }
    public static int[] plusOne(int[] digits){
        int length = digits.length -1;
        int cary = 1;
        List<Integer> result = new ArrayList<>();
        for(int idx=length;idx>=0;idx--){
            if(digits[idx] == 9 && cary == 1){
                result.add(0);
                digits[idx] = 0;
                cary = 1;
                if(idx == 0){
                    result.add(1);
                }
            }
            else{
                digits[idx] += cary;
                result.add(digits[idx]);
                cary = 0;
            }
        }
        digits = new int[result.size()];
        int pIdx = 0;
        for(int idx=result.size() -1;idx>=0;idx--){
           digits[pIdx] = result.get(idx);
           pIdx++;
        }
        return digits;
    }

    public int[] plusOneBest(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }
            // here we have the rightmost not-nine
            else {
                // increase this rightmost not-nine by 1
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }


}
