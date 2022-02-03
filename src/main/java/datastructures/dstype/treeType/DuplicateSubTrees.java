package datastructures.dstype.treeType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/find-duplicate-subtrees/
https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution
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
    //Left node(tree) then right(tree) then root
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
    /*
    * For those who thinks this should be preorder instead, it's actually postorder indeed. Even the cur.val is in the
    * beginning of string serial, it doesn't make the algorithm preorder. The order of value in the string serial doesn't
    * really matter, it's the order that we process subtrees or current tree node first that matters. As the string serial
    * is adding to the HashMap and to the result list (this is when we done processing the current tree node, adding cur.val
    * to serial is not) after we processing things for the left and right subtrees, this is still postorder.
    *
    * The string variable is indeed built in a preorder fashion. But we insert string variable to map when its
    * left and right subtree are done including root. (which is Postorder).
    *
    * */


    //Left node(tree) then right(tree) then root
    //Time complexity: O(N)
    //Space Complexity: O(2N)
    int curId = 1;
    public List<TreeNode> findDuplicateSubtree(TreeNode root) {
        Map<String, Integer> serialToId = new HashMap<>();
        Map<Integer, Integer> idToCount = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();
        postorder(root, serialToId, idToCount, res);
        return res;
    }
    private int postorder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> res) {
        if (root == null) return 0;
        int leftId = postorder(root.left, serialToId, idToCount, res);
        int rightId = postorder(root.right, serialToId, idToCount, res);
        String curSerial = leftId + "," + root.val + "," + rightId;
        int serialId = serialToId.getOrDefault(curSerial, curId);
        if (serialId == curId) curId++;
        serialToId.put(curSerial, serialId);
        idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
        if (idToCount.get(serialId) == 2) res.add(root);
        return serialId;
    }
}
