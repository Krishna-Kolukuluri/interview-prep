package datastructures.dstype.heapType;

import java.util.Collections;
import java.util.PriorityQueue;

/*
*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element
in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).
*
* */
public class KthSmallestElementInMatrix {
    public static void main(String[] args) {

    }
    public static int kthSmallest(int[][] mat, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] row: mat){
            for(int col: row){
                maxHeap.offer(col);
                if(maxHeap.size()>k){
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}
/*
*
Time Complexity: O(MxN)
Space Complexity: O(K).
*
* */