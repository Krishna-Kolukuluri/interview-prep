package datastructures.dstype.heapType;

import java.util.Collections;
import java.util.PriorityQueue;

/*
*
* Find Median from Data Stream
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and
the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
*
* */
public class MedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double result = medianFinder.findMedian();
        System.out.println(result);
        medianFinder.addNum(3);
        result = medianFinder.findMedian();
        System.out.println(result);

    }
}
class MedianFinder{
    PriorityQueue<Integer> minHalf;
    PriorityQueue<Integer> maxHalf;
    public MedianFinder(){
        this.minHalf = new PriorityQueue<>(Collections.reverseOrder());
        this.maxHalf = new PriorityQueue<>();
    }
    public void addNum(int num){
        minHalf.offer(num);
        maxHalf.offer(minHalf.poll());
        if(minHalf.size()<maxHalf.size()){
            minHalf.offer(maxHalf.poll());
        }
    }
    public double findMedian(){
        return minHalf.size()>maxHalf.size()? minHalf.peek(): ((double)(minHalf.peek() + maxHalf.peek())*0.5);
    }
}

/*
*
Complexity Analysis
Time complexity: O(5⋅logn)+O(1)≈O(logn).
At worst, there are three heap insertions and two heap deletions from the top. Each of these takes about O(logn) time.
Finding the median takes constant O(1) time since the tops of heaps are directly accessible.
*
Space complexity: O(n) linear space to hold input in containers.
*
* */

