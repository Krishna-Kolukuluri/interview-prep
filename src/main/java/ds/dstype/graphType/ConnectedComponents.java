package ds.dstype.graphType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Number of Provinces
/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
* */
public class ConnectedComponents {
    //Depth First Search(DFS) Approach
    //Connected Components.
    public int numberOfDistinctGraphsDFS(int[][] M){
        int[] visitedNodes = new int[M.length];
        int numberOfGraphs = 0;
        for(int rowIndex=0; rowIndex<M.length;rowIndex++){
            if(visitedNodes[rowIndex] == 0){
                depthFirstSearch(M, visitedNodes, rowIndex);
                numberOfGraphs++;
            }
        }
        return numberOfGraphs;
    }
    public void depthFirstSearch(int[][] M, int[] visitedNodes, int rowIndex){
        for(int columnIndex = 0; columnIndex<M.length; columnIndex++){
            if(M[rowIndex][columnIndex] == 1 && visitedNodes[columnIndex] == 0){
                visitedNodes[columnIndex] = 1;
                depthFirstSearch(M,visitedNodes, columnIndex);
            }
        }
    }
    /*
    Complexity Analysis(Depth First Search) Algorithm.
    Time complexity : O(n^2) The complete matrix of size n^2 is traversed.
    Space complexity : O(n) visitedNodes array of size n is used.
    */



    //Breadth First Search(BFS) OR Level Order Search(Traversal) Algorithm.
    //Connected Components.
    public int numberOfDistinctGraphsBFS(int[][] M){
        int[] visitedNodes = new int[M.length];
        int numberOfGraphs = 0;
        Queue<Integer> nodeQueue = new LinkedList<>();
        for(int rowIndex = 0; rowIndex<M.length; rowIndex++){
            if(visitedNodes[rowIndex] == 0){
                nodeQueue.offer(rowIndex);
                while (!nodeQueue.isEmpty()){
                    int node = nodeQueue.poll();
                    visitedNodes[node] = 1;
                    for(int columnIndex = 0; columnIndex < M.length; columnIndex++){
                        if(M[node][columnIndex] == 1 && visitedNodes[columnIndex] == 0){
                            nodeQueue.offer(columnIndex);
                        }
                    }
                }
                numberOfGraphs++;
            }
        }
        return numberOfGraphs;
    }
    /*
     Complexity Analysis
     Time complexity : O(n^2). The complete matrix of size n^2 is traversed.
     Space complexity : O(n). A nodeQueue and visitedNodes array of size n is used.
    */


    //Union-Find Method (DisjointSets Algo/DataStructure)
    //Connected Components , Connected Groups
    public int findConnectedComponentsOrGraphs(int[][] M){
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for(int rowIndex = 0; rowIndex < M.length; rowIndex++){
            for(int colIndex = 0; colIndex < M.length; colIndex++){
                if(M[rowIndex][colIndex] == 1 && rowIndex != colIndex){
                    union(parent, rowIndex,colIndex);
                }
            }
        }
        int connectedComponents = 0;
        for(int index = 0; index < parent.length; index++){
            if(parent[index] == -1) {
                connectedComponents++;
            }
        }
        return connectedComponents;
    }
    private int find( int[] parent, int node){
        if(parent[node] == -1){
            return node;
        }
        return find(parent, parent[node]);
    }
    private void union(int[] parent, int rowIndex, int colIndex){
        int xSet = find(parent, rowIndex);
        int ySet = find(parent, colIndex);
        if(xSet != ySet){
            parent[xSet] = ySet;
        }
    }
    /*
     Complexity Analysis
     Time complexity : O(n^3). We traverse over the complete matrix once. Union and find operations take O(n) time in the worst case.
     Space complexity : O(n). parent array of size n is used.
    */


    public int findConnectedComponents(int[][] isConnected){
        if(isConnected == null || isConnected.length == 0){
            return 0;
        }
        int size = isConnected.length;
        QuickUnionByRankFindByPathCompression qubrfpc = new QuickUnionByRankFindByPathCompression(size);
        for(int rowIndex = 0; rowIndex< size; rowIndex++){
            for(int colIndex = 0; colIndex < size; colIndex++){
                if(isConnected[rowIndex][colIndex] == 1){
                    qubrfpc.union(rowIndex,colIndex);
                }
            }
        }
        return qubrfpc.getConnectedComponentsCount();
    }
}

class QuickUnionByRankFindByPathCompression{
    private int[] root;
    private int[] rank;
    private int count;
    public QuickUnionByRankFindByPathCompression(int size){
        root = new int[size];
        rank = new int[size];
        count = size;
        for (int index=0; index<size;index++){
            root[index] = index;
            rank[index] = 1;
        }
    }
    //Path compression
    public int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }
    //By Rank of parent nodes
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            count--;
        }
    }
    public int getConnectedComponentsCount(){
        return count;
    }

}
