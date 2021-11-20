package datastructures.dstype.arraytype;

public class MaxNumConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        int maxConsecutiveOnes = consecutiveOnesBestSolution(nums);
        System.out.println("maxConsecutiveOnes ='" + maxConsecutiveOnes +"'");
        nums = new int[]{1,0,0,1,1,0};
        maxConsecutiveOnes = consecutiveZerosBestSolution(nums);
        System.out.println("maxConsecutiveZeros ='" + maxConsecutiveOnes +"'");

    }

    static int consecutiveOnes(int nums[]){
        int count = 0;
        int maxCount = 0;
        int numsCapacity = 0;
        for(int num: nums){
            numsCapacity++;
            if(num == 1){
                count = count + 1;
                if(numsCapacity == nums.length){
                    if(count > maxCount) {
                        maxCount = count;
                    }
                }
            }
            else{
                if(count > maxCount){
                    maxCount = count;
                }
                count = 0;
            }
        }
        return maxCount;
    }

    static int consecutiveOne(int nums[]){
        int count = 0;
        int maxCount = 0;
        for(int index=0;index<nums.length;index++){
            if(nums[index] == 1){
                count++;
                if(index == nums.length-1){
                    if(count > maxCount) {
                        maxCount = count;
                    }
                }
            }
            else{
                if(count > maxCount){
                    maxCount = count;
                }
                count = 0;
            }
        }
        return maxCount;
    }

    static int consecutiveOnesBestSolution(int nums[]){
        int count = 0;
        int maxCount = 0;
        for(int index=0;index<nums.length;index++){
            count = 0;
            if(nums[index] == 1){
                while (index<nums.length && nums[index] == 1){
                    count++;
                    index++;
                }
                index--;
                if(count>maxCount){
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }

    static int consecutiveZerosBestSolution(int nums[]){
        int count = 0;
        int maxCount = 0;
        for(int index=0;index<nums.length;index++){
            count = 0;
            if(nums[index] == 0){
                while (index<nums.length && nums[index] == 0){
                    count++;
                    index++;
                }
                index--;
                if(count>maxCount){
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }
}
