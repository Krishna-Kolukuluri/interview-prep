package patterns.recursion.dfs;


import recursion.TreeNode;

/*
* https://leetcode.com/problems/cousins-in-binary-tree/solution/
* Cousins in Binary Tree
* Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
* return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
* Two nodes of a binary tree are cousins if they have the same depth with different parents.
* Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
* Example:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
*
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
*
* Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
* */
public class CousinsInBinaryTree {
    int recordedDepth = -1;
    boolean isCousin = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0,x,y);
        return isCousin;
    }
    public boolean dfs(TreeNode node, int depth, int x, int y){
        if(node == null){
            return false;
        }
        // Don't go beyond the depth restricted by the first node found.
        if(recordedDepth != -1 && depth > recordedDepth){
            return false;
        }
        if(node.val == x || node.val == y){
            if(recordedDepth == -1){
                // Save depth for the first node found.
                recordedDepth = depth;
            }
            // Return true, if the second node is found at the same depth.
            return recordedDepth == depth;
        }
        boolean left = dfs(node.left, depth + 1, x , y);
        boolean right = dfs(node.right, depth + 1, x, y);
        // this.recordedDepth != depth + 1 would ensure node x and y are not
        // immediate child nodes, otherwise they would become siblings.
        if(left && right &&  recordedDepth != depth + 1){
            isCousin = true;
        }
        return left || right;
    }
    /*
    *
    * Complexity Analysis:
        Time Complexity: O(N), where NN is the number of nodes in the binary tree. In the worst case, we might have
        to visit all the nodes of the binary tree.

        Let's look into one such scenario. When both Node x and Node y are the leaf nodes and at the last level of the tree,
        the algorithm has no reasons to prune the recursion. It can only come to a conclusion once it visits both the nodes.
        If one of these nodes is the last node to be discovered the algorithm inevitably goes through each and every node in the tree.

      Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would be N,
                        as the height of a skewed binary tree could be, at worst, N. For a left skewed or a right skewed
                        binary tree, where the desired nodes are lying at the maximum depth possible, the algorithm would
                        have to maintain a recursion stack of the height of the tree.
    * */
}
