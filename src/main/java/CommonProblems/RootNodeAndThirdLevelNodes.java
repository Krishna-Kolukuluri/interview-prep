package CommonProblems;

import java.util.*;
/*
*
*
Given an array of arrays, where each array contains two numbers - the first number being a parent and the second number
being a child of a tree - return an array of arrays where the 0ith element is an array of all nodes with no parents (roots),
and the 1st element is an array of all nodes with 3 parents.
*
* */
public class RootNodeAndThirdLevelNodes {
    public static void main(String[] args) {
        int[][] relations = new int[][]{{1,4},{2,4},{3,4},{1,5},{5,6}};
        ArrayRelations arrayRelations = new ArrayRelations();
        System.out.println(arrayRelations.getRootNodeAndNodesWithThreeParents(relations));
    }
}
class  ArrayRelations {
    public List<List<Integer>> getRootNodeAndNodesWithThreeParents(int[][] arrayOfRelationships) {
        Map<Integer, List<Integer>> childToParents = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        for (int[] pc : arrayOfRelationships) {
            List<Integer> nodeParents = childToParents.getOrDefault(pc[1], new ArrayList<>());
            nodeParents.add(pc[0]);
            childToParents.put(pc[1], nodeParents);
            allNodes.add(pc[1]);
            allNodes.add(pc[0]);
        }

        List<Integer> rootNodes = new ArrayList<>();
        List<Integer> threeParents = new ArrayList<>();
        for (int node : allNodes) {
            if (!childToParents.containsKey(node)) {
                rootNodes.add(node);
            } else if (childToParents.get(node).size() == 3) {
                threeParents.add(node);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(rootNodes);
        result.add(threeParents);
        return result;
    }
}
/*
Complexity:
Time: O(N) --> O(N.2) --> O(N) N is number of rows in the relations array.
Space: O(N.2) N is number of rows in the relations array
* */
