package datastructures.dstype.heapType;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
* Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.
*
* */
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        int result = smallestPossibleWeight(stones);
        System.out.println(result);
    }

    public static int smallestPossibleWeight(int[] stones){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //maxHeap.addAll(IntStream.of(stones).boxed().collect(Collectors.toList())); // This is slower compared to for loop.
        for(int stone: stones){
            maxHeap.add(stone);
        }
        while (maxHeap.size()>1){
            int topOne = maxHeap.poll();
            int topTwo = maxHeap.poll();
            if(topOne != topTwo){
                maxHeap.add(Math.abs(topOne - topTwo));
            }
        }
        return maxHeap.isEmpty()?0: maxHeap.poll();
    }
}
