package CommonProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
*
We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays.
For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we
wouldn't include intervals like [5, 5] in our answer, as they have zero length.
*
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
*
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
* */
public class EmployeesFreeTimeExample {
    public static void main(String[] args) {
        EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();
        List<List<Interval>> schedule = new ArrayList<>();
        List<Interval> empSchedule = new ArrayList<>();
        empSchedule.add(new Interval(1,2));
        empSchedule.add(new Interval(5,6));
        schedule.add(empSchedule);
//        empSchedule.clear();
//        empSchedule.add(new Interval(2,4));
//        schedule.add(empSchedule);
        empSchedule = new ArrayList<>();
        empSchedule.add(new Interval(1,3));
        schedule.add(empSchedule);
        empSchedule = new ArrayList<>();
        empSchedule.add(new Interval(4,10));
        schedule.add(empSchedule);
        empSchedule = new ArrayList<>();
        List<Interval> freeTimes = employeeFreeTime.getEmployeesFreeTime(schedule);
        System.out.print("[");
        for(Interval interval: freeTimes){
            System.out.print("["+interval.getStart()+","+interval.getEnd()+"]");
        }
        System.out.print("]");
    }
}
class EmployeeFreeTime{
    public List<Interval> getEmployeesFreeTime(List<List<Interval>> schedule){
        // first step, to change the problem from hard to medium
        // we put all the intervals into one list.
        // Using PriorityQueue to keep it's order. You can use List, and sort it after, but that would be slower
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<Interval>((A,B) -> A.getStart() - B.getStart());
        for(List<Interval> interval: schedule){
            priorityQueue.addAll(interval);
        }
        //now, we have a medium problem, we are going to make it an easy one
        //we will merge overlapped intervals into one
        List<Interval> workHours = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            Interval interval = priorityQueue.poll();
            while (!priorityQueue.isEmpty() && priorityQueue.peek().getStart() <= interval.getEnd()){
                Interval interval1 = priorityQueue.poll();
                interval.setEnd(Math.max(interval.getEnd(), interval1.getEnd()));
            }
            workHours.add(interval);
        }

        //To here, we have an easy problem. Just get the gaps between each working intervals
        List<Interval> freeTimes = new ArrayList<>();
        for(int index=1; index<workHours.size(); index++){
            Interval free = new Interval(workHours.get(index - 1).getEnd(), workHours.get(index).getStart());
            freeTimes.add(free);
        }

        return freeTimes;
    }
}
class Interval{
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Interval(){

    }
    public Interval(int _start, int _end){
        this.start = _start;
        this.end = _end;
    }
}
