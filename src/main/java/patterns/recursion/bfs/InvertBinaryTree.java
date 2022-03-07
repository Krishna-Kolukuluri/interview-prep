package patterns.recursion.bfs;


import recursion.TreeNode;

/*
* https://leetcode.com/problems/invert-binary-tree/
* Invert Binary Tree
* Given the root of a binary tree, invert the tree, and return its root.
* Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
*
Input: root = [2,1,3]
Output: [2,3,1]
* */
public class InvertBinaryTree {
    /*
    *  time complexity is O(n)
    *  space complexity is O(n)
    * */
    public TreeNode invertTree(TreeNode root){
        bfs(root);
        return root;
    }
    public void bfs(TreeNode node){
        if(null == node){
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        bfs(node.left);
        bfs(node.right);
    }
}
