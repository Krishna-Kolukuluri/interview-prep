package recursion;

import java.util.LinkedList;
import java.util.List;

//Given an integer n, return all the structurally unique BST's (binary search trees),
// which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
public class UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n){
        if(n == 0){
            return new LinkedList<TreeNode>();
        }
        return generateUniqueTrees(1, n);
    }

    public LinkedList<TreeNode> generateUniqueTrees(int start, int end){
        LinkedList<TreeNode> all_trees = new LinkedList<>();
        if(start>end){
            all_trees.add(null);
            return all_trees;
        }

        //pick-up a root
        for(int index = start; index <= end; index++){
            //All possible left subtrees if index is chosen to be a root
            LinkedList<TreeNode> left_trees = generateUniqueTrees(start, start - 1);

            //All possible right subtrees if index is chosen to be a root
            LinkedList<TreeNode> right_trees = generateUniqueTrees(start + 1, end);

            //connect left and right trees to root index
            for(TreeNode left : left_trees){
                for(TreeNode right: right_trees){
                    TreeNode current_tree = new TreeNode(index);
                    current_tree.left = left;
                    current_tree.right = right;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }
    //Complexity analysis
    //Catalan number c(n) = 2n!/(n+1)!n!
    //
    //Time complexity : The main computations are to construct all possible trees with a given root, that is actually Catalan number G_nG
    //n
    //​
    //  as was discussed above. This is done n times, that results in time complexity n G_nnG
    //n
    //​
    // . Catalan numbers grow as \frac{4^n}{n^{3/2}}
    //n
    //3/2
    //
    //4
    //n
    //
    //​
    //  that gives the final complexity \mathcal{O}(\frac{4^n}{n^{1/2}})O(
    //n
    //1/2
    //
    //4
    //n
    //
    //​
    // ). Seems to be large but let's not forget that here we're asked to generate G_n \sim \frac{4^n}{n^{3/2}}G
    //n
    //​
    // ∼
    //n
    //3/2
    //
    //4
    //n
    //
    //​
    //  tree objects as output.
    //
    //Space complexity : n G_nnG
    //n
    //​
    //  as we keep G_nG
    //n
    //​
    //  trees with n elements each, that results in \mathcal{O}(\frac{4^n}{n^{1/2}})O(
    //n
    //1/2
    //
    //4
    //n
    //
    //​
    // ) complexity.
}
