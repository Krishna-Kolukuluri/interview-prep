package arraysPrograms;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
*  https://leetcode.com/problems/single-threaded-cpu/
* https://leetcode.com/problems/single-threaded-cpu/discuss/1164102/Java%3A-sort-by-time-and-use-PQ
*
* You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks,
* where tasks[i] = [enqueueTimei, processingTimei] means that the ith task will be available to process at enqueueTimei
* and will take processingTimei to finish processing.

You have a single-threaded CPU that can process at most one task at a time and will act in the following way:
If the CPU is idle and there are no available tasks to process, the CPU remains idle.
If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time.
If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
Once a task is started, the CPU will process the entire task without stopping.
The CPU can finish a task then start a new one instantly.
Return the order in which the CPU will process the tasks.
* */
public class TaskSchedulerOnSingleThreadedCpu {
    public static int[] getOrder(int[][] tasks){
        int n = tasks.length;
        int[] taskExecutionOrder = new int[n];
        int[][] tasksWithPriorities = new int[n][3];
        for(int i = 0; i < n; i++) {
            tasksWithPriorities[i][0] = i;
            //Start time
            tasksWithPriorities[i][1] = tasks[i][0];
            //Time required to complete the task
            tasksWithPriorities[i][2] = tasks[i][1];
        }
        //Sorting tasks based on task start time
        Arrays.sort(tasksWithPriorities, (a, b)->Integer.compare(a[1], b[1]));

        //Ordering entries in PriorityQueue based on  TaskProcessing time when TaskProcessing times are b/w two task then they are ordered based task ids.
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? Integer.compare(a[0], b[0]) : Integer.compare(a[2], b[2]));
        //Current time in the processing flow
        int time = 0;
        //Task completion index
        int tcIdx = 0;
        //Task queuing/scheduling index
        int tsIdx = 0;
        //When task completion index is less than total tasks, keep scheduling them based on cpu time availability
        while(tcIdx < n) {
            //Task/Active index less than total task and currentTask time is up then add it to queue.
            while(tsIdx < n && tasksWithPriorities[tsIdx][1] <= time) {
                pq.offer(tasksWithPriorities[tsIdx]);
                tsIdx++;

            }
            if(pq.isEmpty()) {
                time = tasksWithPriorities[tsIdx][1];
                continue;
            }
            int[] bestFit = pq.poll();
            taskExecutionOrder[tcIdx] = bestFit[0];
            tcIdx++;
            time += bestFit[2];
        }
        return taskExecutionOrder;
    }

    public static void main(String[] args) {
        int[][] tasks = new int[][] {{1,2},{2,4},{3,2},{4,1}};
        System.out.println(Arrays.toString(getOrder(tasks)));
    }
}
