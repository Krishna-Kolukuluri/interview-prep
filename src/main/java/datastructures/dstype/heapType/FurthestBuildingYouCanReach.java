package datastructures.dstype.heapType;

import java.util.PriorityQueue;
/*
*
You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.

You start your journey from building 0 and move to the next building by possibly using bricks or ladders.

While moving from building i to building i+1 (0-indexed),

If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
*
* */
public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] heights = new int[]{4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladders = 2;
        int result = furthestBuilding(heights, bricks, ladders);
        System.out.println(result);

        heights = new int[]{14,3,19,3};
        bricks = 17;
        ladders = 0;
        result = furthestBuilding(heights, bricks, ladders);
        System.out.println(result);
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders){
        PriorityQueue<Integer> jumpsWithLadder = new PriorityQueue<>();
        for(int index =0; index<heights.length-1;index++){
            if(heights[index]<heights[index+1]){
                jumpsWithLadder.offer(heights[index+1] - heights[index]);
                if (jumpsWithLadder.size()<=ladders){
                    continue;
                }
                bricks -= jumpsWithLadder.poll();
                if(bricks<0){
                    return index;
                }
            }
        }
        return heights.length-1;
    }
}
/*
Time complexity : O(NlogN) or O(NlogL).
Inserting or removing an item from a heap incurs a cost of O(logx), where xx is the number of items currently
in the heap. In the worst case, we know that there will be N−1 climbs in the heap, thus giving a time complexity of
O(logN) for each insertion and removal, and we're doing up to N of each of these two operations. This gives a total
time complexity of O(NlogN).
In practice, though, the heap will never contain more than L + 1L+1 climbs at a time—when it gets to this size,
we immediately remove a climb from it. So, the heap operations are actually O(logL). We are still performing
up to N of each of them, though, so this gives a total time complexity of O(NlogL).

Space complexity : O(N) or O(L).
As we determined above, the heap can contain up to O(L) numbers at a time. In the worst case, L=N, so we get O(N)
* */
