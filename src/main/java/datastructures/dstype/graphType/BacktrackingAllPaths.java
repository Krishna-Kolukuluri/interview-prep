package datastructures.dstype.graphType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BacktrackingAllPaths {
    /*
    Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
    The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
    * */
    int targetNode;
    int[][] graph;
    List<List<Integer>> results;
    public List<List<Integer>> allPathsFromSourceToTarget(int[][] graph){
        this.graph = graph;
        targetNode = graph.length - 1;
        results = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<>();
        path.push(0);
        //Kick-off BacktrackingAllPaths to find all paths starting from source node i.e. 0
        this.backtrack(0, path);
        return this.results;
    }
    public void backtrack(int currNode, Stack<Integer> path){
        //Base case when currNode is reaches target node then get complete path into results.
        if(currNode == this.targetNode){
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        //Explore neighbour nodes of currNode for possible candidates for valid paths
        for(int nextNode: graph[currNode]){
            path.push(nextNode);
            backtrack(nextNode, path);
            //Remove the previous choice node, and try next choice ode
            path.pop();
        }
    }
    /*
    Time Complexity: O(2^N  .N)
    Space Complexity: O(2^N  .N)
    * */
}
