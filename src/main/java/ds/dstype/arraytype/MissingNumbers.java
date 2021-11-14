package ds.dstype.arraytype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> misNums = missingNumbers(nums);
        for (Integer num: misNums) {
            System.out.print(" " + num);
        }
        System.out.println(" ");

        nums = new int[]{1,1};
        misNums = missingNumbers(nums);
        for (Integer num: misNums) {
            System.out.print(" " + num);
        }

        System.out.println(" ");

        nums = new int[]{5,4,6,7,9,3,10,9,5,6};
        misNums = missingNumbers(nums);
        for (Integer num: misNums) {
            System.out.print(" " + num);
        }

    }

    private static List<Integer> missingNumbersInEfficient(int[] nums){
        List<Integer> missingNums = new ArrayList<>();
        List<Integer> numsList  = new ArrayList<>();
        Arrays.sort(nums);
        for (int num: nums) {
            numsList.add(num);
        }
        for(int index = 1; index <= nums.length; index++ ){
            if(!numsList.contains(index)){
                missingNums.add(index);
            }
        }

        return missingNums;
    }

    private static List<Integer> missingNumbers(int[] nums){
        List<Integer> missingNums = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            int val = Math.abs(nums[index]) - 1;
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }
        }

        for(int index = 0; index < nums.length; index++){
            if(nums[index] > 0){
                missingNums.add(index + 1);
            }
        }

        return missingNums;
    }
}
