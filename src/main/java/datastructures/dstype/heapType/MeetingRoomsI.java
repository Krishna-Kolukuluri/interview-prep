package datastructures.dstype.heapType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
*
* https://leetcode.com/problems/meeting-rooms/
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
*
Constraints:
0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106
* */
public class MeetingRoomsI {
    public static void main(String[] args) {
       int[][] intervals = {{0,30},{5,10},{15,20}};
       System.out.println(canAttendMeeting(intervals));
       intervals = new int[][]{{7,10},{2,4}};
        System.out.println(canAttendMeeting(intervals));
    }
    private static boolean canAttendMeetings(int[][] intervals){

        if(intervals.length <2){
            return true;
        }
        //Creating minHeap
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>((A,B) -> {
            if(A.start == B.start){
                return A.end - B.end;
            }
            else {
                return A.start - B.start;
            }
        });
        for(int[] interval : intervals){
            Meeting meeting = new Meeting(interval[0], interval[1]);
            minHeap.offer(meeting);
        }
        while (!minHeap.isEmpty()){
            Meeting meetingOne = minHeap.poll();
            if(!minHeap.isEmpty()){
                Meeting nextMeeting = minHeap.peek();
                if(meetingOne.end>nextMeeting.start){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canAttendMeeting(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
    /*
    Complexity Analysis

    Time complexity : O(nlogn). The time complexity is dominated by sorting. Once the array has been sorted,
    only O(n) time is taken to go through the array and determine if there is any overlap.

    Space complexity : O(1). Since no additional space is allocated.
    * */
}
