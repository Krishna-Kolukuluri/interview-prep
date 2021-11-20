package datastructures.dstype.arraytype;

public class PivotIndex {
    public static void main(String[] args) {

    }
    public int getPivotIndex(int[] nums){
        //Sum of all left values for index i should be equal to sum of all right values for index i in nums array.
        //return index i. Index i is called as pivot index.
        int sumOfAllNums = 0;
        int leftSum = 0;
        for(int num:nums){
            sumOfAllNums += num;
        }
        for(int index=0;index<nums.length;index++){
            if(leftSum == sumOfAllNums - leftSum - nums[index]){
                return index;
            }
            leftSum += nums[index];
        }
        return -1;
    }
    /*
    Complexity Analysis
    Time Complexity: O(N)O(N), where NN is the length of nums.
    Space Complexity: O(1)O(1), the space used by leftsum and S.
    * */
}
