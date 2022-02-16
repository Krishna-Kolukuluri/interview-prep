package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* https://leetcode.com/problems/average-of-levels-in-binary-tree/
*
* Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
* Answers within 10-5 of the actual answer will be accepted.
*
* */
public class AvgOfLevelsInBinaryTree {
    public static void main(String[] args) {

    }


    public static List<Double> averageOfLevels(TreeNode root){
        List<Integer> levels = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        DFS(root,0, levels, sums);
        List<Double> avgs = new ArrayList<>();
        for(int i=0; i<levels.size(); i++){
            avgs.add((double) (sums.get(i)/levels.get(i)));
        }
        return avgs;
    }

    /*
    * Complexity Analysis:
        Time complexity : O(n). The whole tree is traversed once only. Here, nn refers to the total number of nodes in the given binary tree.
        Space complexity : O(h). res and count array of size hh are used. Here, hh refers to the height(maximum number of levels) of the given binary tree.
                           Further, the depth of the recursive tree could go upto hh only.
    * */
    public static void DFS(TreeNode root, int level, List<Integer> levelList,List<Double> sumList){
        if(root == null) return;
        if(level < sumList.size()){
            levelList.set(level, levelList.get(level) + 1);
            sumList.set(level, sumList.get(level) + root.val);
        }else{
            levelList.add(1);
            sumList.add(1.0 * root.val);
        }

        if(root.left != null){
            DFS(root.left, level  + 1, levelList, sumList);
        }
        if(root.right != null){
            DFS(root.right, level + 1, levelList, sumList);
        }
    }

    /*
    * Complexity Analysis:
        Time complexity : O(n). The whole tree is traversed utmost once. Here, nn refers to the number of nodes in the given binary tree.
        Space complexity : O(m). The size of queue or temp can grow upto utmost the maximum number of nodes at any level in the given binary tree.
                           Here, m refers to the maximum number of nodes at any level in the input tree.
    *
    * */
    public List < Double > averageOfLevelsBFS(TreeNode root) {
        List < Double > res = new ArrayList < > ();
        Queue< TreeNode > queue = new LinkedList< >();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue < TreeNode > temp = new LinkedList < > ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
    }
}
