package ds.dstype.graphType;
/*
Problem Statement:
All Paths from Source Lead to Destination
Given the edges of a directed graph where edges[i] = [ai, bi] indicates there is an edge between nodes ai and bi,
and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually,
end at destination, that is:

At least one path exists from the source node to the destination node
If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
The number of possible paths from source to destination is a finite number.
Return true if and only if all roads from source lead to destination.
* */

import java.util.*;

/*
Intuition:
Let's try to boil the problem down to simpler, more commonly understandable terms.
We are given a directed graph.
Also, as inputs we are provided a source and a destination.
We need to tell if all the paths from the source lead to the destination and and we can split this into a few criteria.
If a path exists from the source node to a node with no outgoing edges, then that node must be equal to destination.
Here, we simply need to see that if a node does not have any neighbors in the adjacency list structure, then it has to
be the destination or else we return false.
The number of possible paths from source to destination is a finite number. This simply means that the graph is actually
a tree. Or in other words, there are no cycles in the graph. If there is a cycle in the graph, there would be an infinite
number of paths from the source to the destination, as each would go around the cycle a different number of times.
* */
public class AllPathsLeadToDestination {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visitedNodes = new HashSet<>();
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination){
        //Step 1. Build graph
        for(int index=0; index<n;index++){
            graph.put(index, new ArrayList<>());
        }
        for(int[] edge: edges){
            int start = edge[0];
            int end = edge[1];
            List<Integer> neighbours = graph.getOrDefault(start, new ArrayList<>());
            neighbours.add(end);
            graph.put(start, neighbours);
        }
        if(graph.get(destination).size()>0){
            return false;
        }
        return depthFirstSearch(source, destination);
    }
    public boolean depthFirstSearch(int curNode, int destination){
        if(graph.get(curNode).size() == 0){
            return curNode == destination;
        }
        visitedNodes.add(curNode);
        if(graph.get(curNode) != null) {
            for (Integer nextNode : graph.get(curNode)) {
                //Checking for cycle
                if(visitedNodes.contains(nextNode)){
                    return false;
                }
                //Backtracking technique
                visitedNodes.add(nextNode);
                boolean result = depthFirstSearch(nextNode, destination);
                if (!result) {
                    return false;
                }
                visitedNodes.remove(nextNode);
            }
        }
        return true;
    }
    /*
    Complexity Analysis

    Time Complexity: Typically for an entire DFS over an input graph, it takes O(V+E) where V represents
    the number of vertices in the graph and likewise, E represents the number of edges in the graph. In the worst case E
    can be O(V^2) in case each vertex is connected to every other vertex in the graph. However even in the worst case, we will end up
    discovering a cycle very early on and prune the recursion tree. If we were to traverse the entire graph, then the
    complexity would be O(V^2) as the O(E) part would dominate. However, due to pruning and backtracking in case of cycle detection,
    we end up with an overall time complexity of O(V).
    Space Complexity: O(V+E) where O(E) is occupied by the adjacency list and O(V) is occupied by the recursion stack and
    the color states.
    * */
}
