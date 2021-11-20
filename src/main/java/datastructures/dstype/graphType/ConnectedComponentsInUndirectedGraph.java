package datastructures.dstype.graphType;

import java.util.ArrayList;
import java.util.List;
/*
Number of Connected Components in an Undirected Graph
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that
there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.
* */
public class ConnectedComponentsInUndirectedGraph {
    //Union Find data-structure Approach
    class UnionFind{
        private int[] parents;
        private int[] ranks;
        int components;
        //Making component sets, at the beginning each node is separate component i.e. nodes parent is node itslef and
        //rank is 1.
        public UnionFind(int size){
            parents = new int[size];
            ranks = new int[size];
            components = size;
            for(int node=0;node<size;node++){
                parents[node] = node;
                ranks[node] = 1;
            }
        }
        //Path compression to reduce callbacks and update parents -> parents --> root parents directly which will
        // reduce time complexity to O(1)
        public int findParent(int node){
            if(node == parents[node]){
                return node;
            }
            return parents[node] = findParent(parents[node]);
        }
        //Optimizing union with each parent nodes rank
        public void union(int nodeA, int nodeB){
            int parentOfA = findParent(nodeA);
            int parentOfB = findParent(nodeB);
            if(parentOfA != parentOfB){
                if(ranks[parentOfA] > ranks[parentOfB]){
                    parents[parentOfB] = parentOfA;
                }else if(ranks[parentOfA]<ranks[parentOfB])
                {
                    parents[parentOfA] = parentOfB;
                }
                else{
                    parents[parentOfB] = parentOfA;
                    ranks[parentOfA] += 1;
                }
                components--;
            }
        }
        public int getConnectedComponentsCount(){
            return components;
        }
    }
    public int connectedComponents(int n, int[][] edges){
        UnionFind unionFind = new UnionFind(n);
        for(int[] edge:edges){
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.getConnectedComponentsCount();
    }

    //Depth-First Search Recursion
    public int connectedComponentsDfs(int n, int[][] edges){
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int components = 0;
        int[] seenNodes = new int[n];

        for(int node=0;node< n;node++){
            adjacencyList.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).get(edge[0]);
        }
        for(int node=0;node<n;node++ ){
            if(seenNodes[node] == 0){
                components++;
                depthFirstSearch(adjacencyList, seenNodes, node);
            }
        }
        return components++;
    }
    public void depthFirstSearch(List<List<Integer>> adjacencyList, int[] seenNodes, int currentNode){
        seenNodes[currentNode] = 1;
        for(int neighbourNode =0; neighbourNode<adjacencyList.get(currentNode).size();neighbourNode++){
            if(seenNodes[adjacencyList.get(currentNode).get(neighbourNode)] == 0){
                depthFirstSearch(adjacencyList, seenNodes,adjacencyList.get(currentNode).get(neighbourNode) );
            }
        }
    }
}
