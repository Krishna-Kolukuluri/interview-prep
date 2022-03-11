package salesforce;

/**
Example 1:
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

Example 2:
Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
**/

public class SmallestDivisor {
    public int findSum(int[] nums, int curDivisor) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            double curNum = (double) nums[i]/curDivisor;
            int ceilNum = (int) Math.ceil(curNum);
            sum += ceilNum;
        }
        return sum;
    }
    int getMaximum(int[] nums) {
        int maxNum = 0;
        for(int i=0;i<nums.length;i++) {
            maxNum = Math.max(nums[i],maxNum);
        }
        return maxNum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int res = Integer.MAX_VALUE;
        int low = 1;
        int high =getMaximum(nums);
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            int sum = findSum(nums,mid);
            
            if(sum <= threshold) {
                res = mid;
                high = mid-1;
                
            }else {
                low = mid+1;
            }
            
        }
        return res;
    }

}
