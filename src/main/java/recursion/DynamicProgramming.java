package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicProgramming {
    int[][] graph;
    int target;
    HashMap<Integer, List<List<Integer>>> memo;
    public List<List<Integer>> allPathsFromSourceToTarget(int[][] graph){
        this.graph = graph;
        target = graph.length - 1;
        memo = new HashMap<>();
        return allPathsToTarget(0);
    }

    public List<List<Integer>> allPathsToTarget(int currNode){
        //Check the results in cache first (memoization)
        if(memo.containsKey(currNode)){
            return memo.get(currNode);
        }
        List<List<Integer>> results = new ArrayList<>();

        //Base case
        if(currNode == target){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(currNode);
            results.add(path);
            return results;
        }

        //Iterate through all paths starting from currNode each neighbour.
        for(int nextNode: graph[currNode]){
            for(List<Integer> path: allPathsToTarget(nextNode)){
                ArrayList<Integer> newPath = new ArrayList<>();
                newPath.add(currNode);
                newPath.addAll(path);
                results.add(newPath);
            }
        }

        //Memoization
        memo.put(currNode, results);
        return results;

    }
}
