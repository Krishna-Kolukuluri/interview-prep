package ds.dstype.arraytype;

import java.util.Arrays;

public class DeleteElements {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int[] removedCount = removeElement(nums, val);
        for(int num:removedCount){
            System.out.println("removedCount ='" + num +"'");
        }

        nums = new int[]{3,2,2,3};
        val = 3;
        removedCount = removeElement(nums, val);
        for(int num:removedCount){
            System.out.println("removedCount ='" + num +"'");
        }
        System.out.println(removedCount);

    }

    static int[] removeElement(int[] nums, int valToRemove){
        int count = 0;
        for(int index=0;index<nums.length;index++){
            if(nums[index] != valToRemove){
                nums[count++] = nums[index];
            }
        }

        return nums;
    }

}
