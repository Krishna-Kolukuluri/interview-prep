package patterns.binarysearch;

import recursion.TreeNode;

/*
* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
* Lowest Common Ancestor of a Binary Search Tree
* Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*
* Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
* */
public class LCAOFBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(null == left && null == right){
            return null;
        }
        if(null != left && null != right){
            return root;
        }

        return left != null? left: right;
    }
}
