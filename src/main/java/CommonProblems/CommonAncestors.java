package CommonProblems;

import java.util.*;
import java.util.stream.Collectors;
/*
*
Given an array of arrays, where each array contains two numbers - the first number being a parent and the second number
being a child of a tree -, and two nodes - node1 and node2 - return an array of all common ancestors.
*
* */
public class CommonAncestors {
    public static void main(String[] args) {
        int[][] relations = new int[][]{{4,3},{5,4},{6,5},{7,4},{10,6},{2,10},{9,7},{8,7},{1,9}};
        Ancestors ancestors = new Ancestors();
        System.out.println(ancestors.findCommonAncestors(relations, 4,3));
    }
}
class Ancestors{
    public List<Integer> findCommonAncestors(int[][] relations, int nodeOne, int nodeTwo){
        HashMap<Integer, List<Integer>> childToParents = new HashMap<>();
        for(int[] pc:relations){
            List<Integer> tempParents = childToParents.getOrDefault(pc[1], new ArrayList<>());
            tempParents.add(pc[0]);
            childToParents.put(pc[1], tempParents);
        }
        Set<Integer> nodeOneParents = findParents(nodeOne, childToParents);
        Set<Integer> nodeTwoParents = findParents(nodeTwo, childToParents);
        nodeOneParents.retainAll(nodeTwoParents);
        List<Integer> commonAncestors = nodeOneParents.stream().collect(Collectors.toList());
        return commonAncestors;
    }
    private Set<Integer> findParents(int node, HashMap<Integer, List<Integer>> childToParents){
        Set<Integer> ancestors = new HashSet<>();
        Stack<Integer> nodeChain = new Stack<>();
        nodeChain.add(node);
        while (!nodeChain.isEmpty()){
            int currNode = nodeChain.pop();
            if(childToParents.containsKey(currNode)) {
                List<Integer> parents = childToParents.get(currNode);
                for (int parent : parents) {
                    ancestors.add(parent);
                    nodeChain.add(parent);
                }
            }
        }
        return ancestors;
    }
}
