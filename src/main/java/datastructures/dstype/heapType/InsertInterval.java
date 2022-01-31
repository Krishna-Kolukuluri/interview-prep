package datastructures.dstype.heapType;

import java.util.LinkedList;

/*
* https://leetcode.com/problems/insert-interval/
* insert meeting --> tag
* You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start
* and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval
* newInterval = [start, end] that represents the start and end of another interval.

* Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still
* does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

* Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
*
* Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*
* */
public class InsertInterval {
    /*
    * Algorithm:
        Here is the algorithm :
        Add to the output all the intervals starting before newInterval.
        Add to the output newInterval. Merge it with the last added interval if newInterval starts before the last added interval.
        Add the next intervals one by one. Merge with the last added interval if the current interval starts before the last added interval.
    * */
    public static int[][] insertInterval(int[][] intervals, int[] newInterval){
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        LinkedList<int[]> result = new LinkedList<>();
        int idx=0;
        int n = intervals.length;

        while (idx<n && newStart> intervals[idx][0]){
            result.add(intervals[idx]);
            idx++;
        }

        int[] interval = new int[2];

        if(result.isEmpty() || result.getLast()[1]< newStart){
            result.add(newInterval);
        }else {
            interval = result.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            result.add(interval);
        }

        while (idx<n){
            interval = intervals[idx];
            idx++;
            int start = interval[0];
            int end = interval[1];

            if(result.getLast()[1]< start){
                result.add(interval);
            }else {
                interval = result.removeLast();
                interval[1] = Math.max(interval[1], end);
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
    /*
    * Complexity Analysis
        Time complexity : O(N) since it's one pass along the input array.
        Space complexity : O(N) to keep the output.
    * */

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] result = insertInterval(intervals, newInterval);
        for(int[] interval: result){
            System.out.println("["+interval[0]+","+interval[1]+"]");
        }
    }
}
