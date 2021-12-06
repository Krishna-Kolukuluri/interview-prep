package CommonProblems;

import java.util.Collections;
import java.util.PriorityQueue;
/*
*
Given an  unsorted array find min, max , median and average with least complexity
*
* */
public class CalculateMinMaxMedAvgOfArray {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        int[] nums = new int[]{1,4,5,2,6,3,9,8,7,10,11};
        System.out.println("Average=" + calculate.Average(nums));
        System.out.println("Max=" + calculate.Max(nums));
        System.out.println("Min=" + calculate.Min(nums));
        System.out.println("Median=" + calculate.Median(nums));
    }
}
class Calculate{
    public double Average(int[] nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return (double) sum/nums.length;
        //O(N) Time complexity
    }
    public double Median(int[] nums){
        //nums is unsorted
        int length  = nums.length/2;
        if(nums.length%2 == 0){
            double median;
            median = (double) (kthSmallest(nums, length) + kthSmallest(nums, length + 1))/2;
            return median;
        }
        else{
            return kthSmallest(nums, length+1);
        }
        //O(N) Time complexity
    }
    public int Min(int[] nums){
        return kthSmallest(nums, 1);
    }
    public int Max(int[] nums){
        return  kthSmallest(nums, nums.length);
    }
    private int kthSmallest(int[] nums, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            maxHeap.offer(num);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
