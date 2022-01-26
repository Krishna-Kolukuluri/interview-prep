package amazon.arrayandstrings;

import java.util.HashMap;

public class SumOfTwoTarget {
    public static void main(String args[]) {
        int[] nums={3,5,6,2,7,4,11,15,18,4,30};
        int target = 9;
        sumoftwonums_target(nums,target);
        sumoftwonums_target(nums,8);
    }
    static int[] sumoftwonums_target(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            //Checking if element is less than target
            if(nums[i]<target){
                int diff = target-nums[i];
                if(map.containsKey(diff)){
                    result[1] = i;
                    result[0] = map.get(diff);
                    System.out.println(result[0]+"  :  "+result[1]);
                }
                map.put(nums[i],i);
            }
        }
        return result;
        
    }
}
