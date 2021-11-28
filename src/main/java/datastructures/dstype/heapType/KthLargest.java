package datastructures.dstype.heapType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
* not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
*
* */
public class KthLargest {
    int k;
    int[] nums;
    //To keep all elements in heap
    PriorityQueue<Integer> maxHeap;
    //To get k largest elements from stream.
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums){
        this.k  = k;
        this.nums = nums;
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        maxHeap.addAll(IntStream.of(nums).boxed().collect(Collectors.toList()));
        minHeap.addAll(IntStream.of(nums).boxed().collect(Collectors.toList()));
        while (minHeap.size()>k){
            minHeap.poll();
        }
    }
    public int add(int val){
        maxHeap.add(val);
        minHeap.add(val);
        if(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }

}
