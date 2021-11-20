package datastructures.dstype.arraytype;

import java.util.*;

/*
Top K Frequent Elements
Problem Statement:
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
* */
public class TopKFrequentElements {
    /*
    Complexity Analysis
    Time complexity : O(Nlogk) if k < N and O(N) in the particular case of N=k. That ensures time complexity to be
    better than O(NlogN).
    Space complexity : O(N+k) to store the hash map with not more NN elements and a heap with k elements.
    * */
    public int[] findTopKFrequentElements(int[] nums, int k){
        //Create counts of elements
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        //Keep top K frequent elements in heap priority queue sorts queue based on each element count value.
        Queue<Integer> heap = new PriorityQueue<>((n1,n2) -> map.get(n1) - map.get(n2));
        for(Integer key: map.keySet()){
            heap.offer(key);
            if(heap.size()>k){
                heap.poll();
            }
        }
        //Convert top k Frequent elements from queue to list.
        int[] topK = new int[k];
        int idx =0;
        while (!heap.isEmpty()){
            topK[idx] = heap.poll();
            idx++;
        }
       return  topK;
    }
}
