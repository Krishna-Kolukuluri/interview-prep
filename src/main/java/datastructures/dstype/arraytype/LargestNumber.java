package datastructures.dstype.arraytype;

public class LargestNumber {
    public static void main(String[] args) {

    }
    public int getLargestInteger(int[] nums){
        int max = 0;
        int secondMax = 0;
        int maxIndex = 0;
        for(int index=0;index<nums.length;index++){
            if(nums[index] > max){
                maxIndex = index;
                secondMax = max;
                max = nums[index];
            }else if(nums[index]>secondMax){
                secondMax = nums[index];
            }
        }
        if((max - (2*secondMax) >= 0)){
            return maxIndex;
        }
        return -1;
    }
}
