package patterns.dividenconquer;

import datastructures.dstype.treeType.TreeNode;

/*
* https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
* Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
* A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
* Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
* */
public class ArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums =  new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
    }
    private static int[] _nums;
    public static TreeNode sortedArrayToBST(int[] nums){
        _nums = nums;
        return DFS(0, nums.length-1);
    }

/*    Preorder Tree traversal
    node, left, right*/
    public static TreeNode DFS(int left, int right){
        if(left > right){
            return null;
        }
        //New root index, always choose from left middle element from left part of sorted array between left and right
        int p = (left + right)/2;

        //New root index, always choose from right middle element from left part of sorted array between left and right
        /* int p = (left + right)/2;
        if((left+right)%2 == 1) {
            p++;
        }*/

        //preorder traversal node, left, right
        TreeNode root = new TreeNode(_nums[p]);
        root.left = DFS(left, p-1);
        root.right = DFS(p+1, right);
        return root;
    }
}
