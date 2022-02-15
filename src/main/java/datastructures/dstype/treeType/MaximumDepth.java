package datastructures.dstype.treeType;
/*
* https://leetcode.com/problems/maximum-depth-of-binary-tree/
* Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
* Input: root = [3,9,20,null,null,15,7]
Output: 3
*
* */
/*
* Complexity analysis:
Time complexity : we visit each node exactly once, thus the time complexity is O(N), where NN is the number of nodes.
Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the
* recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N).
* But in the best case (the tree is completely balanced), the height of the tree would be log(N). Therefore,
* the space complexity in this case would be O(log(N)).
* */
public class MaximumDepth {
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int ans = 1;
    public int maxDepthTopDownBottomUp(TreeNode root) {
        if (root == null)
            return 0;
        //topDown(root, ans);
        return bottomUp(root);
        //return ans;
    }

    public void topDown(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            ans = Math.max(ans, depth);
        topDown(root.left, depth + 1);
        topDown(root.right, depth + 1);
    }

    public int bottomUp(TreeNode root) {
        if (root == null)
            return 0;
        int left_d = bottomUp(root.left);
        int right_d = bottomUp(root.right);
        return Math.max(left_d, right_d) + 1;
    }

}
