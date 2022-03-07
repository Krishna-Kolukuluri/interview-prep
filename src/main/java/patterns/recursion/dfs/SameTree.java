package patterns.recursion.dfs;

import recursion.TreeNode;

/*
* https://leetcode.com/problems/same-tree/
* Same Tree or Symmetric Tree
* Given the roots of two binary trees p and q, write a function to check if they are the same or not.
* Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
* Input: p = [1,2,3], q = [1,2,3]
Output: true
*
* Input: p = [1,2], q = [1,null,2]
Output: false
*
* Input: p = [1,2,1], q = [1,1,2]
Output: false
*
* */
public class SameTree {
    public boolean sameTree = true;
    public boolean isSameTree(TreeNode p, TreeNode q){
        return dfsSameTree(p, q);
    }
    /*
    * Complexity Analysis:
        Time complexity : O(N), where N is a number of nodes in the tree, since one visits each node exactly once.
        Space complexity : O(log(N)) in the best case of completely balanced tree and O(N) in the worst case of completely
                           unbalanced tree, to keep a recursion stack.
    *
    * */
    public boolean dfsSameTree(TreeNode p, TreeNode q){
        if(null == p && null == q){
            return true;
        }
        if(null == p || null == q){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return dfsSameTree(p.right, q.right) && dfsSameTree(p.left, q.left);
    }
}
