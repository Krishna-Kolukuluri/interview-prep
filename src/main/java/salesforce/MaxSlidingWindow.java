package salesforce;

import java.util.ArrayDeque;
import java.util.Deque;

//O(n)

/**You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
**/

public class MaxSlidingWindow {
    
    
    /*
     * O(nk)
     */
    public int[] maxSlidingWindowEasy(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) 
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
    
//  The algorithm is quite straightforward :
//
//      Iterate along the array in the direction left->right and build an array left.
//
//      Iterate along the array in the direction right->left and build an array right.
//
//      Build an output array as max(right[i], left[i + k - 1]) for i in range (0, n - k + 1).
  
  
      public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
          // from left to right
          if (i % k == 0) left[i] = nums[i];  // block_start
          else left[i] = Math.max(left[i - 1], nums[i]);

          // from right to left
          int j = n - i - 1;
          if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
          else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
          output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
      }
    
      /**
      Process the first k elements separately to initiate the deque.

      Iterate over the array. At each step :

      Clean the deque :

      Keep only the indexes of elements from the current sliding window.

      Remove indexes of all elements smaller than the current one, since they will not be the maximum ones.

      Append the current element to the deque.

      Append deque[0] to the output.

      Return the output array.
      **/

      static ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
       static int [] numbers;

      public static void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
          deq.removeFirst();

        // remove from deq indexes of all elements 
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && numbers[i] > numbers[deq.getLast()])                           
            deq.removeLast();
      }

      public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        numbers = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
          clean_deque(i, k);
          deq.addLast(i);
          // compute max in nums[:k]
          if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
          clean_deque(i, k);
          deq.addLast(i);
          output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
      }
      
    public static void main(String args[]){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] result =  maxSlidingWindowDeque(nums,3);
        for(int i: result){
            System.out.println(i);
        }
    }
}
