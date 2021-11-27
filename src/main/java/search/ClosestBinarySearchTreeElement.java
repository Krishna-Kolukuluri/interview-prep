package search;

import datastructures.dstype.treeType.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
* */
public class ClosestBinarySearchTreeElement {
    public static void main(String[] args) {
    }

    public static int getClosestValue(TreeNode root, double target){
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        Collections.sort(values, (A, B) -> {
            return Math.abs(A - target) <  Math.abs(B - target)? -1: 1;
        } );
        return values.get(0);

    }
    public static void inOrderTraversal(TreeNode node, List<Integer> nums){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left, nums);
        nums.add(node.val);
        inOrderTraversal(node.right, nums);
    }
}
/*
Complexity Analysis
Time complexity : \mathcal{O}(N)O(N) because to build inorder traversal and then to perform linear search takes linear time.
Space complexity : \mathcal{O}(N)O(N) to keep inorder traversal.
* */
