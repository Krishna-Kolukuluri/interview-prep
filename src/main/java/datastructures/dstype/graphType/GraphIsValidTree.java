package datastructures.dstype.graphType;

import java.util.*;

public class GraphIsValidTree {
//Approach 1: Graph Theory + Iterative DFS
//
// Note that this same approach also works with recursive depth-first search and iterative breadth-first search.
// We'll look at these briefly in the Algorithm section.
//
//Graph Theory
//Recall that a graph, G, is a tree iff the following two conditions are met:
//1. G is fully connected. In other words, for every pair of nodes in G, there is a path between them.
//2. G contains no cycles. In other words, there is exactly one path between each pair of nodes in G.
/*
Complexity Analysis
Let E be the number of edges, and N be the number of nodes.

Time Complexity : O(N + E).
Creating the adjacency list requires initialising a list of length N, with a cost of O(N),
and then iterating over and inserting E edges, for a cost of O(E). This gives us O(E) + O(N) =O(N+E).
Each node is added to the data structure once. This means that the outer loop will run NN times. For each of the N nodes,
its adjacent edges is iterated over once. In total, this means that all EE edges are iterated over once by the inner loop.
This, therefore, gives a total time complexity of O(N+E).
Because both parts are the same, we get a final time complexity of O(N + E).

Space Complexity : O(N+E).
The adjacency list is a list of length N, with inner lists with lengths that add to a total of E.
This gives a total of O(N+E) space.
In the worst case, the stack/ queue will have all N nodes on it at the same time, giving a total of O(N) space.
In total, this gives us O(E+N) space.
*/
    public boolean isValidGraphDfsWithSet(int n, int[][] edges){
       //Create new empty list for each node to hold its neighbours
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int index = 0; index<n;index++){
            adjacencyList.add(new ArrayList<>());
        }
        //Convert edges into Adjacency List for each corresponding node to use breadth-first or depth-first search
        //look up of neighbours of a node.
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        //Depth-First search/traversal of nodes and its neighbours.
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedNodes = new HashSet<>();
        //Starting with node '0' for our search.
        stack.push(0);
        visitedNodes.add(0);
        while (!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour: adjacencyList.get(node)){
                if(visitedNodes.contains(neighbour)){
                    //Node already seen, either graph should have a trivial cycle or actual cycle
                    //Nodes that form Trivial cycle is are removed(in below code) from revisiting even than if a
                    // neighbour is seen already it only tells that graph have a cycle.
                    return false;
                }
                //Adding neighbour to stack and visitedNodes set.
                visitedNodes.add(neighbour);
                stack.push(neighbour);

                //To ignore/skip trivial cycles i.e. for set(A,B) in undirected graph. A -> B -> A is called trivial cycle.
                adjacencyList.get(neighbour).remove(node);
            }
        }
        // If the graph is fully connected, then every node must have been seen i.e. visitedNodes set contain all nodes.
        return visitedNodes.size() == n;
    }

    // This approach is better compared 'Set' approach as, we are not changing adjacency list values.
    public boolean isValidGraphDfsWithMap(int n, int[][] edges){
        //Create new empty list for each node to hold its neighbours
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int index = 0; index<n;index++){
            adjacencyList.add(new ArrayList<>());
        }
        //Convert edges into Adjacency List for each corresponding node to use breadth-first or depth-first search
        //look up of neighbours of a node.
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        //Depth-First search/traversal of nodes and its neighbours.
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nodeParents = new HashMap<>();
        //Starting with node '0' for our search.
        stack.push(0);
        nodeParents.put(0, -1);
        while (!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour: adjacencyList.get(node)){
                // Don't look at the trivial cycle
                if(nodeParents.get(node) == neighbour){
                    continue;
                }
                // Check if we've already seen this node.
                if(nodeParents.containsKey(neighbour)){
                    // neighbour is seen already it only tells that graph have a cycle.
                    return false;
                }
                //Adding neighbour to stack and visitedNodes set.
                nodeParents.put(neighbour, node);
                stack.push(neighbour);
            }
        }
        // If the graph is fully connected, then every node must have been seen i.e. visitedNodes set contain all nodes.
        return nodeParents.size() == n;
    }

    //Depth-First Search recursive.
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();

    public boolean isValidGraphDfsRecur(int n, int[][] edges){
        //Create new empty list for each node to hold its neighbours
        for(int index = 0; index<n;index++){
            adjacencyList.add(new ArrayList<>());
        }
        //Convert edges into Adjacency List for each corresponding node to use breadth-first or depth-first search
        //look up of neighbours of a node.
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        // We return true iff no cycles were detected,
        // AND the entire graph has been reached.
        return depthFirstSearch(0, -1) && seen.size() == n;
    }
    private boolean depthFirstSearch(int node, int parent){
        if(seen.contains(node)) {
            return false;
        }
        seen.add(node);
        for(int neighbour: adjacencyList.get(node)){
            if(parent != neighbour){
                boolean result = depthFirstSearch(neighbour, node);
                if(!result) return false;
            }
        }
        return true;
    }
    //Breadth-First Search appraoch.
    public boolean isValidGraphBfsIter(int n, int[][] edges){
        //Create new empty list for each node to hold its neighbours
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int index = 0; index<n;index++){
            adjacencyList.add(new ArrayList<>());
        }
        //Convert edges into Adjacency List for each corresponding node to use breadth-first or depth-first search
        //look up of neighbours of a node.
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        HashMap<Integer, Integer> parents = new HashMap<>();
        parents.put(0, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour: adjacencyList.get(node)){
                if(parents.get(node) == neighbour){
                    //Trivial Cycle skip it.
                    continue;
                }
                if(parents.containsKey(neighbour)){
                    return false;
                }
                queue.offer(neighbour);
                parents.put(neighbour, node);
            }
        }

        return parents.size() == n;
    }


//Approach 2: Advanced Graph Theory + Iterative Depth-First Search
//Intuition:
/*
For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't possibly be fully connected.
Any more, and it has to contain cycles. Additionally, if the graph is fully connected and contains exactly n - 1 edges,
it can't possibly contain a cycle, and therefore must be a tree!

Going by this definition, our algorithm needs to do the following:

1. Check whether or not there are n - 1 edges. If there's not, then return false.
2. Check whether or not the graph is fully connected. Return true if it is, false if otherwise.
* */

/*
Complexity Analysis
Let EE be the number of edges, and NN be the number of nodes.
Time Complexity : O(N).
When E ≠ N - 1 we simply return false. Therefore, the worst case is when E = N−1. Because E is proportional to N,
we'll say E=N to simplify the analysis.
As said above, creating an adjacency list has a time complexity of O(N+E). Because E is now bounded by N,
we can reduce this slightly to O(N + N) = O(N).

The iterative breadth-first search and depth-first search are almost identical. Each node is put onto the queue/stack once,
ensured by the seen set. Therefore, the inner "neighbour" loop runs once for each node. Across all nodes,
the number of cycles this loop does is the same as the number of edges, which is simply NN. Therefore,
these two algorithms have a time complexity of O(N).

The recursive depth-first search's "neighbour" loop runs only once for each node. Therefore, in total,
the function is called once for each edge. So it is called $E = N times, and NN of those times,
it actually enters the "neighbour" loop. Collectively, the total number of iterations of the "neighbour" loop is
E = N. So we get O(N), as these all simply add.

Space Complexity : O(N).
Previously, we determined that the adjacency list took O(E+N) space. We now know this is simply O(N).
In the worst case, the search algorithms will require an additional O(N) space; this is if all nodes were on the stack/queue at the same time.
So again we get a total of O(N).
* */

    public boolean isValidTreeDfsIter(int n, int[][] edges){
        if(n - 1 != edges.length){
            return false;
        }
        List<List<Integer>> adjacencyList = new ArrayList<>();
        HashMap<Integer, Integer> parents = new HashMap<>();
        for(int index = 0; index<n; index++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        //Depth-First Search
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        parents.put(0, -1);
        while (!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour: adjacencyList.get(node)){
                if(parents.get(node) == neighbour){
                    continue;
                }
                if(parents.containsKey(neighbour)){
                    return false;
                }
                parents.put(neighbour, node);
                stack.push(neighbour);
            }
        }
        return parents.size() == n;
    }

    // isValidTreeDfsRecur
    public boolean isValidTreeDfsRecur(int n, int[][] edges){
       if(edges.length != n -1){
           return false;
       }
       for(int index=0;index<n;index++){
           adjacencyList.add(new ArrayList<>());
       }
       for(int[] edge: edges){
           adjacencyList.get(edge[0]).add(edge[1]);
           adjacencyList.get(edge[1]).add(edge[0]);
       }
       depthFirstSearchAGT(0);
       return seen.size() == n;
    }
    private void depthFirstSearchAGT(int node){
        if(seen.contains(node)) return;
        seen.add(node);
        for(int neighbour: adjacencyList.get(node)){
            depthFirstSearchAGT(neighbour);
        }
    }
    //End isValidTreeDfsRecur

    //Breadth-First Search Iterative
    private boolean isValidTreeBfsIter(int n, int[][] edges){
        if(n - 1 != edges.length){
            return false;
        }
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for(int index = 0; index<n; index++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        seen.add(0);
        queue.offer(0);
        while (!queue.isEmpty()){
            int node  = queue.poll();
            for(int neighbour: adjacencyList.get(node)){
                if(seen.contains(neighbour)){
                    continue;
                }
                seen.add(neighbour);
                queue.offer(neighbour);
            }
        }

        return seen.size() == n;
    }
    //End Breadth-First Search Iterative


// Approach 3: Advanced Graph Theory + Union Find
//Intuition:
/*
For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't possibly be fully connected.
Any more, and it has to contain cycles. Additionally, if the graph is fully connected and contains exactly n - 1 edges,
it can't possibly contain a cycle, and therefore must be a tree!

Going by this definition, our algorithm needs to do the following:

1. Check whether or not there are n - 1 edges. If there's not, then return false.
2. Check whether or not the graph is fully connected. Return true if it is, false if otherwise.
* */
/*
Complexity Analysis
Let E be the number of edges, and NN be the number of nodes. α(N) is the Inverse Ackermann Function.
Time Complexity : O(N⋅α(N)).
When E ≠ N - 1, we simply return false. Therefore, the worst case is when E = N - 1.
Because E is proportional to NN, we'll say E = N to simplify the analysis.

We are putting each of the N edges into the UnionFind data structure, using the union(...) method.
The union(...) method itself has no loops or recursion, so the entire cost of calling it is dependent on the cost of the
find(...) method that it calls.
find(...)'s cost is dependent on how far the node it was searching for is from the root. Using the naïve
implementation of union find, this depth could be NN. If this was the case for all of the calls, we'd have a final cost of O(N^2)

However, remember those optimizations we did? Those keep the tree depths very shallow.
It turns out that find(...) amortizes to O(α(N)), where α is the Inverse Ackermann Function.
The incredible thing about this function is that it grows so slowly that NN will never go higher than 4 in the universe
as we know it! So while in "practice" it is effectively O(1), in "theory" it is not.

Actually proving this upper bound on the depth is a very advanced proof, which I'd certainly hope you'd never
need to do in an interview! If you're interested though, I recommend looking in a good algorithm's text book or paper.
Anyway, this gives us a total of N⋅O(α(N))=O(N⋅α(N)).

Space Complexity : O(N).
The UnionFind data structure requires O(N) space to the store the arrays it uses.

*/
    public boolean isValidTreeUinonFindWithOpt(int n, int[][] edges){
        // Condition 1: The graph must contain n - 1 edges.
        if(n-1 != edges.length){
            return false;
        }
        // Condition 2: The graph must contain a single connected component.
        // Create a new UnionFind object with n nodes.
        UnionFind unionFind = new UnionFind(n);
        // Add each edge. Check if a merge happened, because if it
        // didn't, there must be a cycle.
        for(int[] edge: edges){
            if(!unionFind.union(edge[0], edge[1])){
                return false;
            }
        }
        // If we got this far, there's no cycles!
        return true;
    }
}
class UnionFind{
    private int[] root;
    private int[] rank;
    public UnionFind(int size){
        root = new int[size];
        rank = new int[size];
        for(int index=0;index<size;index++){
            root[index] = index;
            rank[index] = 1;
        }
    }
    public int find(int node){
        if(node == root[node]){
            return node;
        }
        return root[node] = find(root[node]);
    }
    public boolean union(int nodeOne, int nodeTwo){
        int parentOfNodeOne = find(nodeOne);
        int parentOfNodeTwo = find(nodeTwo);
        if(parentOfNodeOne == parentOfNodeTwo){
            return false;
        }
        if(rank[parentOfNodeOne] >= rank[parentOfNodeTwo]){
            root[parentOfNodeTwo] = parentOfNodeOne;
            rank[parentOfNodeOne] += rank[parentOfNodeTwo];
        }else {
            root[parentOfNodeOne] = parentOfNodeTwo;
            rank[parentOfNodeTwo] += rank[parentOfNodeOne];
        }
        return true;
    }
}
