package amazon.arrayandstrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            for (int j = i + 1; j < sz - 1; ++j) {
                int complement = target - nums[i] - nums[j];
                int idx = Arrays.binarySearch(nums, j + 1, sz - 1, complement);
                int hi = idx >= 0 ? idx : ~idx, lo = hi - 1;
                if (hi < sz && Math.abs(complement - nums[hi]) < Math.abs(diff))
                    diff = complement - nums[hi];
                if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
                    diff = complement - nums[lo];
            }
        }
        return target - diff;
    }
    
    public static void main(String args[]){
        int numbers[] = { 12, 11, 13, 5, 6, 7,3, 6 };
        System.out.println(threeSumClosest(numbers,5));
        System.out.println(EasyThreeSum(numbers,5));
    }
    
    //Other Way Time complexity: O(N3) Space Complexity: O(1). 
    public static int EasyThreeSum(int arr[], int x) 
    { 
        
        // To store the closest sum 
        int closestSum = Integer.MAX_VALUE; 
      
        // Run three nested loops each loop  
        // for each element of triplet 
        for(int i = 0; i < arr.length ; i++)  
        { 
            for(int j = i + 1; j < arr.length; j++) 
            { 
                for(int k = j + 1; k < arr.length; k++) 
                { 
                    
                    // Update the closestSum 
                    if (Math.abs(x - closestSum) > 
                        Math.abs(x - (arr[i] + arr[j] + arr[k]))) 
                        closestSum = (arr[i] + arr[j] + arr[k]); 
                }  
            } 
        } 
        
        // Return the closest sum found 
        return closestSum; 
    } 
    
    //Other Way Time complexity: O(N2) Space Complexity: O(1). 
    static int solution(Vector<Integer> arr, int x)
    {

        // Sort the array
        Collections.sort(arr);

        // To store the closest sum
          // Assigning long to avoid overflow condition
          // when array has negative integers
        long closestSum = Integer.MAX_VALUE;

        // Fix the smallest number among
        // the three integers
        for (int i = 0; i < arr.size() - 2; i++) 
        {

            // Two pointers initially pointing at
            // the last and the element
            // next to the fixed element
            int ptr1 = i + 1, ptr2 = arr.size() - 1;

            // While there could be more pairs to check
            while (ptr1 < ptr2)
            {

                // Calculate the sum of the current triplet
                int sum = arr.get(i) + arr.get(ptr1) + arr.get(ptr2);

                // If the sum is more closer than
                // the current closest sum
                if (Math.abs(x - sum) < Math.abs(x - closestSum)) 
                {
                    closestSum = sum;
                }

                // If sum is greater then x then decrement
                // the second pointer to get a smaller sum
                if (sum > x) 
                {
                    ptr2--;
                }

                // Else increment the first pointer
                // to get a larger sum
                else
                {
                    ptr1++;
                }
            }
        }

        // Return the closest sum found
        return (int)closestSum;
    }
}
