package binaryTree;

import java.util.*;

public class GenerateBinaryTrees {

    public static LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
          all_trees.add(null);
          return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
          // all possible left subtrees if i is choosen to be a root
          LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

          // all possible right subtrees if i is choosen to be a root
          LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

          // connect left and right trees to the root i
          for (TreeNode l : left_trees) {
            for (TreeNode r : right_trees) {
              TreeNode current_tree = new TreeNode(i);
              current_tree.left = l;
              current_tree.right = r;
              all_trees.add(current_tree);
            }
          }
        }
        return all_trees;
      }

      public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
          return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
      }
      
      static int height(TreeNode root)
      {
          if (root == null)
              return 0;
          else {
              int lheight = height(root.left);
              int rheight = height(root.right);
              if (lheight > rheight)
                  return (lheight + 1);
              else
                  return (rheight + 1);
          }
      }
      static void printLevelOrder(TreeNode root)
      {
          int h = height(root);
          int i;
          for (i = 1; i <= h; i++)
              printCurrentLevel(root, i);
      }
      
      static void printCurrentLevel(TreeNode root, int level)
      {
          if (root == null)
              return;
          if (level == 1)
              System.out.print(root.val + " ");
          else if (level > 1) {
              printCurrentLevel(root.left, level - 1);
              printCurrentLevel(root.right, level - 1);
          }
      }
      public static void main(String args[]){
          List<TreeNode> trees = generateTrees(3);
          for(TreeNode node:trees){
              printLevelOrder(node);
              System.out.println("  ");
          }
      }
}

  class TreeNode {
       int val;
        TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
