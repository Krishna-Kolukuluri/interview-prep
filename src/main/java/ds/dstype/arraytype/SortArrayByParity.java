package ds.dstype.arraytype;

public class SortArrayByParity {
    public static void main(String[] args) {

        int[] nums = new int[]{3,1,2,4};
        nums = sortArrayByParity(nums);
        for(int val:nums){
            System.out.println(val);
        }
    }

    static int[] sortArrayByParity(int[] nums){
        int[] tempArr = new int[nums.length];
        int len = nums.length - 1;
        int writeIndex = 0;
        int rightIndex = len;

        for(int readIndex = 0; readIndex <=len; readIndex++){
            if(nums[readIndex] % 2 == 0){
                tempArr[writeIndex++] = nums[readIndex];
            }
            else{
                tempArr[rightIndex--] = nums[readIndex];
            }
        }
        return tempArr;
    }
}
