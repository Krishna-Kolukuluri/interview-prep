package datastructures.dstype.treeType;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
* https://leetcode.com/problems/symmetric-tree/
* Symmetric Tree
* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
*
* */
public class SymmetricTree {
    public boolean isSymmetricTree(TreeNode root){
        return root==null || isSymmetricBreadthFirstSearch(root.left,root.right);
    }
    /*
    * Complexity Analysis:
        Time complexity : O(n). Because we traverse the entire input tree once, the total run time is O(n),
                          where n is the total number of nodes in the tree.

        Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree
                           is linear and the height is in O(n). Therefore, space complexity due to recursive calls on
                           the stack is O(n) in the worst case.
    * */
    public boolean isSymmetricBreadthFirstSearch(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return  false;
        }
        return isSymmetricBreadthFirstSearch(left.left, right.right) &&
                isSymmetricBreadthFirstSearch(left.right, right.left);
    }

    //Queue version. Using Stack instead of Queue will reduce max size to which a list of TreeNodes will grow
    //(with stack you will remove recently added NULL TreeNodes right away, but with queue you will add 2^(n-1) NULL
    // TreeNodes before removing them (assuming we have a complete tree).
    public boolean isSymmetricIter(TreeNode root){
        if(root == null) return true;
        Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
        tempQueue.offer(root.left);
        tempQueue.offer(root.right);
        while (!tempQueue.isEmpty()){
            TreeNode left = tempQueue.poll();
            TreeNode right = tempQueue.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return  false;
            }
            if(left.val != right.val)
            {
                return false;
            }
            tempQueue.offer(left.left);
            tempQueue.offer(right.right);
            tempQueue.offer(left.right);
            tempQueue.offer(right.left);
        }
        return true;
    }


    public boolean isSymmetricIterStack(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> tempStack  = new Stack<TreeNode>();
        tempStack.push(root.left);
        tempStack.push(root.right);
        while (!tempStack.isEmpty()){
            TreeNode right = tempStack.pop();
            TreeNode left = tempStack.pop();
            if(left == null && right == null) continue;
            else if(left == null || right == null || left.val != right.val) return false;
            tempStack.push(left.left);
            tempStack.push(right.right);
            tempStack.push(left.right);
            tempStack.push(right.left);
        }
        return true;
    }
}
