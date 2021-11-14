package ds.dstype.graphType.minimumspanningtree;

import java.util.PriorityQueue;

/*
Problem Statement:
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
where |val| denotes the absolute value of val.
Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path
between any two points.
* */
//Minimum Spanning Tree
//Kurskal Algorithm to find MST in undirected weighted graph.
public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectingPoints(points));
    }
    public static int minCostConnectingPoints(int[][] points){
        int nodes = points.length;
        int totalCost = 0;
        //Declaring priority queue to store edges with weights and sorting(ASC) nodes based on edge weights
        //Greedy approach to solving minimum cost.
        PriorityQueue<int[]> weightedGraph = new PriorityQueue<>((nodeA, nodeB) -> nodeA[0] - nodeB[0]);
        for(int rowIndex=0;rowIndex<nodes;rowIndex++){
            //colIndex starts with rowIndex+1 to ignore (0,0), (1,1) , (2,2) i.e. trivial edges/cycles in graph.
            for(int colIndex=rowIndex+1; colIndex<nodes;colIndex++){
                weightedGraph.add(new int[]{calculateWeight(points, rowIndex, colIndex),rowIndex,colIndex});
            }
        }
        int edges = 0;
        //Using Union-Find algorithm(Disjointset data-structure) to find two nodes are connected or not.
        UnionFind unionFind = new UnionFind(nodes);
        while (edges < nodes -1){
            int[] nodeWithEdge = weightedGraph.poll();
            int cost = nodeWithEdge[0];
            int nodeA = nodeWithEdge[1];
            int nodeB = nodeWithEdge[2];
            if(!unionFind.connected(nodeA, nodeB)){
                totalCost += cost;
                edges++;
                unionFind.union(nodeA, nodeB);
            }
        }
        return totalCost;
    }
    public static int calculateWeight(int[][] points, int nodeA, int nodeB){
        //The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
        // where |val| denotes the absolute value of val.
        return Math.abs(points[nodeA][0] - points[nodeB][0]) + Math.abs(points[nodeA][1] - points[nodeB][1]);
    }

    static class UnionFind{
        int[] parents;
        int[] ranks;
        public UnionFind(int size){
            parents = new int[size];
            ranks = new int[size];
            for(int index=0;index<size;index++){
                parents[index] = index;
                ranks[index] = 1;
            }
        }
        public int find(int node){
            if(node == parents[node]){
                return node;
            }
            return parents[node] = find(parents[node]);
        }
        public void union(int nodeA, int nodeB){
            int parentOfA = find(nodeA);
            int parentOfB = find(nodeB);
            if(ranks[parentOfA] > ranks[parentOfB]){
                parents[parentOfB] = parentOfA;
            }else if(ranks[parentOfA] < ranks[parentOfB]){
                parents[parentOfA] = parentOfB;
            }else{
                parents[parentOfB] = parentOfA;
                ranks[parentOfA] += 1;
            }
        }
        public boolean connected(int nodeA, int nodeB){
            return find(nodeA) == find(nodeB);
        }
    }
    /*
    Time Complexity: O(ElogE). Here, EE represents the number of edges.
    For C++ and Java, building a priority queue takes O(ElogE) time.
    Popping out all the elements from the queue takes O(E \log E)O(ElogE) time as well.
    Therefore, total time complexity for this solution is O(ElogE)+O(ElogE)=O(ElogE).

    Space Complexity: O(E). We need the space to store all the edges in a priority queue.
    * */
}
