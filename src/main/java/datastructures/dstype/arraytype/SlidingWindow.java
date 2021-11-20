package datastructures.dstype.arraytype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{6,1,4,6,3,2,7,4};
        List<Integer[]> result = maximumSumOfThreeConsecutiveElements(nums, 3);
        System.out.println(result);
    }

    //nums are non negative integers
    public static List<Integer[]> maximumSumOfThreeConsecutiveElements(int[] nums, int k){
        int max = 0;
        List<Integer[]> indexes = new ArrayList<Integer[]>();
        HashMap<Integer, List<HashSet>> result;

        for(int idx=0;idx<nums.length-k+1;idx++){
            int it = 0;
            int temSum =0;
            Integer[] index = new Integer[k];

            while (it<k){
                temSum += nums[idx+it];
                index[it]=idx + it;
                it++;
            }
            if(temSum>=max){
                max = temSum;

                indexes.add(index);
            }
        }
        return indexes;
    }
}
