package datastructures.dstype.heapType;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of
conference rooms required.
*
* */
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        int numOfRooms = minMeetingRooms(intervals);
        System.out.println(numOfRooms);
    }
    public static int minMeetingRooms(int[][] intervals){
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>((A,B) -> {
            if(A.start == B.start){
                return A.end - B.end;
            }
            else {
                return A.start - B.start;
            }
        });
        for(int[] meeting: intervals){
            Meeting meet = new Meeting(meeting[0], meeting[1]);
            minHeap.add(meet);
        }
        PriorityQueue<Integer> endMinHeap = new PriorityQueue<>();
        while (!minHeap.isEmpty()){
            if(!endMinHeap.isEmpty()){
                if (endMinHeap.peek() <= minHeap.peek().getStart()) {
                    endMinHeap.poll();
                }
            }
            endMinHeap.add(minHeap.poll().getEnd());
        }
        return endMinHeap.size();
    }
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
class Meeting{
    int start;
    int end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int getStart(){
        return this.start;
    }
    public int getEnd(){
        return this.end;
    }
    public void setStart(int start){
        this.start = start;
    }
    public void setEnd(int end){
        this.end = end;
    }
}
