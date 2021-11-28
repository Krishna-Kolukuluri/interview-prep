package datastructures.dstype.heapType;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
*
* */
public class KthLargestElement {
    public static void main(String[] args) {

    }
    //Using MaxHeap
    public static int findKthLargest(int[] nums, int k){
        if(nums.length < k){
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(IntStream.of(nums).boxed().collect(Collectors.toList()));
        while (k>=0 && !maxHeap.isEmpty()){
            maxHeap.poll();
            k--;
        }
        return maxHeap.poll();
    }
    //Using MinHeap
    public static int findKthLargestWithMinHeap(int[] nums, int k){
        if(nums.length < k){
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
