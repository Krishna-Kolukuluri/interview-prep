package binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
*  https://leetcode.com/problems/find-leaves-of-binary-tree/ binary tree leaves
* Given the root of a binary tree, collect a tree's nodes as if you were doing this:
    Collect all the leaf nodes.
    Remove all the leaf nodes.
    Repeat until the tree is empty.
* Example 1:
Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
* */
public class FindBinaryTreeLeaves {

    /*
    * DFS (Depth-First Search) without sorting: postorder traversal i.e.order of node visiting left, right then parent(center) nodes
    * */
    private static List<List<Integer>> result;
    public static List<List<Integer>> findLeaves(TreeNode root){
        result = new ArrayList<>();
        getHeight(root);
        return result;
    }
    private static int getHeight(TreeNode root){
        // return -1 for null nodes
        if(root == null){
            return  -1;
        }
        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        //height(root)=1+max(height(root.left), height(root.right))
        int currentNodeHeight = 1 + Math.max(leftHeight, rightHeight);

        if(result.size() == currentNodeHeight){
            result.add(new ArrayList<>());
        }
        result.get(currentNodeHeight).add(root.val);

        return currentNodeHeight;
    }
    /*
    * Complexity Analysis:
        Time Complexity: Assuming N is the total number of nodes in the binary tree, traversing the tree takes O(N) time
            and storing all the pairs at the correct position also takes O(N) time. Hence, overall time complexity of this approach is O(N).
        Space Complexity: O(N), the space used by solution array.
    * */

}
