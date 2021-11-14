package ds.dstype.graphType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
399. Evaluate Division
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi]
and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
* */
public class DirectedWeightedGraphEvaluateDivision {
    //This problem can be solved by graph traversal(path search) i.e. DFS or BFS and UnionFind data-structure(disjointSet).
/*
Intuition
Given the above problem statement, it seems intuitive that one could apply the ds.dstype.graphType.BacktrackingAllPaths algorithm,
or sometimes people might call it DFS (Depth-First Search).
Essentially, we can break down the algorithm into two steps overall:
Step 1). we build the graph out of the list of input equations.
Each equation corresponds to two edges in the graph.
Step 2). once the graph is built, we then can evaluate the query one by one.
The evaluation of the query is done via searching the path between the given two variables.
Other than the above searching operation, we need to handle two exceptional cases as follows:
Case 1): if either of the nodes does not exist in the graph, i.e. the variables did not appear in any of the input equations,
then we can assert that no path exists.
Case 2): if the origin and the destination are the same node, i.e. a/a, we can assume that there exists an invisible
self-loop path for each node and the result is one.
* */
    //Build graph and search dividend node and divisor node along graph paths.
    public double[] calcEquations(List<List<String>> equations, double[] values, List<List<String>> queries){
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        //Step 1. Build graph from equations/input nodes which values we know i.e. edges, weights and edge direction.
        for(int index=0;index<equations.size();index++){
            List<String> equation = equations.get(index);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[index];

            if (!graph.containsKey(dividend))
                graph.put(dividend, new HashMap<String, Double>());
            if (!graph.containsKey(divisor))
                graph.put(divisor, new HashMap<String, Double>());

            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        //Step 2. Evaluate each query via Depth-First Search (tail) by verifying if there exists a path from dividend to
        //divisor.
        double[] results = new double[queries.size()];
        for(int index=0;index<queries.size();index++){
            List<String> query = queries.get(index);
            String dividend = query.get(0);
            String divisor = query.get(1);
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)){
                results[index] = -1.0;
            }else if(dividend == divisor){
                results[index] = 1.0;
            }else{
                HashSet<String> visitedNodes = new HashSet<>();
                results[index] = depthFirstSearchEvaluateEquation(graph, dividend, divisor, 1, visitedNodes);
            }
        }
        return results;
    }
    private double depthFirstSearchEvaluateEquation(HashMap<String, HashMap<String, Double>> graph, String currentNode,
                                                  String targetNode, double accruedProduct, HashSet<String> visitedNodes){
        //Mark visited node
        visitedNodes.add(currentNode);
        double result = -1.0;

        Map<String, Double> neighbours = graph.get(currentNode);
        if(neighbours.containsKey(targetNode)){
            result = accruedProduct * neighbours.get(targetNode);
        }else{
            for(Map.Entry<String, Double> pair: neighbours.entrySet()){
                String nextNode = pair.getKey();
                if(visitedNodes.contains(nextNode)){
                    continue;
                }
                result = depthFirstSearchEvaluateEquation(graph,nextNode, targetNode,accruedProduct * pair.getValue(), visitedNodes);
                if(result != -1.0){
                    break;
                }
            }
        }

        //Unmark visit, for next dfs.
        visitedNodes.remove(currentNode);
        return result;
    }

/*
Note: with the built graph, one could also apply the BFS (Breadth-First Search) algorithm, as opposed to the DFS algorithm we employed.
However, the essence of the solution remains the same, i.e. we are searching for a path in a graph.

Complexity Analysis
Let N be the number of input equations and M be the number of queries.
Time Complexity: O(M⋅N)
First of all, we iterate through the equations to build a graph. Each equation takes O(1) time to process.
Therefore, this step will take O(N) time in total.
For each query, we need to traverse the graph. In the worst case, we might need to traverse the entire graph,
which could take O(N). Hence, in total, the evaluation of queries could take M⋅O(N)=O(M⋅N).
To sum up, the overall time complexity of the algorithm is O(N)+O(M⋅N)=O(M⋅N)

Space Complexity: O(N)
We build a graph out the equations. In the worst case where there is no overlapping among the equations,
we would have N edges and 2N nodes in the graph. Therefore, the space complexity of the graph is O(N+2N)=O(3N)=O(N).
Since we employ the recursion in the ds.dstype.graphType.BacktrackingAllPaths, we would consume additional memory in the function call stack,
which could amount to O(N) space.
In addition, we used a set visited to keep track of the nodes we visited during the ds.dstype.graphType.BacktrackingAllPaths.
The space complexity of the visited set would be O(N).
To sum up, the overall space complexity of the algorithm is O(N)+O(N)+O(N)=O(N).

Note that we did not take into account the space needed to hold the results. Otherwise, the total space complexity would be O(N+M)
* */
}
