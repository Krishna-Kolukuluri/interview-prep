package ds.dstype.treeType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
Problem Statement:
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.
* */
public class DuplicateSubTrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        List<TreeNode> result = new LinkedList<>();
        postOrderTraversal(root, new HashMap<>(), result);
        return result;
    }
    //Left node(tree) then right(tree).
    //Time complexity: O(N^2)
    //Space Complexity: O(N^2)
    public String postOrderTraversal(TreeNode curNode, HashMap<String, Integer> map, List<TreeNode> result){
        if(curNode == null) return  "#";
        String nodePath = curNode.val + "," + postOrderTraversal(curNode.left, map, result) + "," + postOrderTraversal(curNode.right, map, result);
        map.put(nodePath, map.getOrDefault(nodePath, 0)+1);
        //Checking for exact 2 is important
        if(map.get(nodePath) == 2){
            result.add(curNode);
        }
        return nodePath;
    }
}
