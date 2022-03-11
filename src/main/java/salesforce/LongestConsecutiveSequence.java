package salesforce;

import java.util.*;

/**
Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

 */
public class LongestConsecutiveSequence {
    
        public static int longestConsecutive(int[] nums) {
            if (nums.length == 0)  return 0;
            Arrays.sort(nums);
            int val = nums[0];
            int max = 1, count = 1;
            for (int i = 1; i < nums.length; i++){
                if (nums[i] == val) {
                   continue;
                } else if (nums[i] == val + 1) { // present  = previous + 1
                    count++;
                    val = nums[i];
                } else { //count starts from next one
                    val = nums[i];
                    count = 1;
                }
                max = Math.max(max, count);
            }
            return max;
        }
        
        //O(n)
        public static int longestConsecutiveHS(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }
            for(Integer i:num_set){
                System.out.println(i);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num-1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum+1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
        
        public static void main(String args[]){
            int[] nums = {0,3,7,5,8,4,6,0,1};
            System.out.println(longestConsecutiveHS(nums));
        }

}
