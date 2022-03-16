package datastructures.dstype.graphType;
/*
* https://leetcode.com/problems/find-if-path-exists-in-graph/
* There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges
* in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge
* between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
You want to determine if there is a valid path that exists from vertex source to vertex destination.
Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
* */
public class PathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end){
        DisjointSet disjointSet = new DisjointSet(n);
        for(int[] edge: edges){
            disjointSet.union(edge[0], edge[1]);
        }
        return disjointSet.connected(start, end);
    }

    class DisjointSet{
        int[] parents;
        int[] ranks;
        public DisjointSet(int size){
            parents = new int[size];
            ranks = new int[size];
            for(int vertex=0;vertex<size;vertex++){
                parents[vertex] = vertex;
                ranks[vertex] = 1;
            }
        }
        public int findParent(int vertex){
            if(vertex == parents[vertex]){
                return vertex;
            }
            return parents[vertex] = findParent(parents[vertex]);
        }
        public void union(int vertexA, int vertexB){
            int rootOfA = findParent(vertexA);
            int rootOfB = findParent(vertexB);
            if(rootOfA != rootOfB){
                if (ranks[rootOfA] > ranks[rootOfB]) {
                    parents[rootOfB] = rootOfA;
                }else if (ranks[rootOfA] < ranks[rootOfB]){
                    parents[rootOfA] = rootOfB;
                }else {
                    parents[rootOfB] = rootOfA;
                    ranks[rootOfA] += 1;
                }
            }
        }
        public boolean connected(int vertexA, int vertexB){
            return findParent(vertexA) == findParent(vertexB);
        }
    }
}
