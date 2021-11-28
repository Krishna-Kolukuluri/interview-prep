package datastructures.dstype.heapType;

import java.util.PriorityQueue;
/*
*
You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i]
is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the
sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.
*
* */
public class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        int[] sticks = new int[]{1,8,3,5};
        int cost = costToConnectSticks(sticks);
        System.out.println(cost);

        sticks = new int[]{3354,4316,3259,4904,4598,474,3166,6322,8080,9009};
        cost = costToConnectSticks(sticks);
        System.out.println(cost);
    }
    public static int costToConnectSticks(int[] sticks){
        if(sticks.length <= 1){
            return 0;
        }
        int totalCost = 0;
        PriorityQueue<Integer> minSticksHeap = new PriorityQueue<>();
        for(int stickLength:sticks){
            minSticksHeap.offer(stickLength);
        }
        while (minSticksHeap.size() > 1){
            int stickOne = minSticksHeap.poll();
            int stickTwo = minSticksHeap.poll();
            int cost = stickOne + stickTwo;
            totalCost += cost;
            minSticksHeap.offer(cost);
        }
        return totalCost;
    }
}
