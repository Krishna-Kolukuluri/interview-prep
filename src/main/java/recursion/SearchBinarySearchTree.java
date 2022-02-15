package recursion;
/*
* https://leetcode.com/problems/search-in-a-binary-search-tree/
* You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
* */
public class SearchBinarySearchTree {
    public static void main(String[] args) {

    }
    public TreeNode searchBST(TreeNode root, int val){
        if(root == null || root.val == val){
            return root;
        }
        return searchBST(root.val < val  ? root.right: root.left, val);
    }

    public TreeNode searchBSTLessMem(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val == val) return root;
        else if(root.val < val) return searchBSTLessMem(root.right,val);
        else return searchBSTLessMem(root.left,val);
    }
}
