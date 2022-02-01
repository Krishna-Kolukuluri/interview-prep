package binaryTree;
/*
* https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
*
* You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n.
* You are also given an integer startValue representing the value of the start node s, and a different integer destValue
* representing the value of the destination node t.
*Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a
* string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.
* Example 1:
Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
* Example 2:
Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.
* */
public class DirectionFromOneNodeToAnotherNode {
    /*
    *
    * The shortest path between any two nodes in a tree must pass through their Lowest Common Ancestor (LCA).
    * The path will travel upwards from node s to the LCA and then downwards from the LCA to node t.
    * TC : O(N)
    * SC : O(N) recursion
    * */
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();

        findPath(root, startValue, s); // find reversed path of startValue
        findPath(root, destValue, d); // find reversed path of destValue

        int i = 0;
        int min_i = Math.min(s.length(), d.length());

        // to find the Least Common Ancestor(LCA) we need to cpmpare the strings from backwards
        while (i < min_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1)) {
            i++;
        }

        // for remaining of the 's' (excluding LCA) replace by 'U' because of upward movement
        // the 'd' has to be reversed in order to go downwards from LCA to destValue
        return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
    }

    // find path of startValue and destValue from the root
    // These paths are from down towards root, so actua;l path from root can be gettable by reversing the sb
    private boolean findPath(TreeNode root, int val, StringBuilder sb) {
        if(root.val == val) {
            return true;
        }

        if(root.left != null && findPath(root.left, val, sb)) {
            sb.append("L");
        }

        else if(root.right != null && findPath(root.right, val, sb)) {
            sb.append("R");
        }

        return sb.length() > 0;
    }
}
