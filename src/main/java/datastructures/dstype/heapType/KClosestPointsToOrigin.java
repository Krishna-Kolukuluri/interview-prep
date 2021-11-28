package datastructures.dstype.heapType;

import java.util.PriorityQueue;

/*
*
* K Closest Points to Origin
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k
closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
*
* */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {

    }
    public static int[][] kClosest(int[][] points, int k){
        PriorityQueue<Point> minPointsHeap = new PriorityQueue<Point>((A,B) ->{
            if(A.getDistanceToOrigin() < B.getDistanceToOrigin()){
                return 1;
            }
            else if(A.getDistanceToOrigin()>B.getDistanceToOrigin()){
                return -1;
            }
            else {
                return 0;
            }
        });
        for(int[] point: points){
            Point minPoint = new Point(point[0], point[1]);
            minPointsHeap.offer(minPoint);
            if(minPointsHeap.size()>k){
                minPointsHeap.poll();
            }
        }
        int[][] minDistancePoints = new int[k][2];
        int temp = 0;
        while (!minPointsHeap.isEmpty() || temp<k){
            int[] point = new int[2];
            Point minPoint = minPointsHeap.poll();
            point[0] = minPoint.getX();
            point[1] = minPoint.getY();
            minDistancePoints[temp] = point;
            temp++;
        }
        return minDistancePoints;
    }
}
class Point{
    int x;
    int y;
    double distanceToOrigin;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
        //this.distanceToOrigin = Math.sqrt(Math.pow((this.x),2) + Math.pow((this.y), 2));
        this.distanceToOrigin = Math.sqrt((this.x * this. x) + (this.y * this.y));
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public double getDistanceToOrigin(){
        return this.distanceToOrigin;
    }
}
