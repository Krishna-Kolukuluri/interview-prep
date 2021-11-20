package datastructures.dstype.treeType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Breadth-First Search or Traversal of Binary Tree with Queue DS
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderTraversalRec(TreeNode root){
        List<List<Integer>> resultList = new ArrayList<>();
        breadthFirstSearch(root, resultList, 0);
        return resultList;
    }
    public void breadthFirstSearch(TreeNode node, List<List<Integer>> resultList, int level){
        if(node == null) return;
        if(resultList.size() - 1 < level){
            resultList.add(level, new ArrayList<>());
        }
        resultList.get(level).add(node.val);
        breadthFirstSearch(node.left, resultList, level+1);
        breadthFirstSearch(node.right, resultList, level+1);
    }


    public List<List<Integer>> levelOrderTraversalIter(TreeNode root){
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
        if(root != null)
            nodesQueue.offer(root);
        while (!nodesQueue.isEmpty()){
            int levelNumber = nodesQueue.size();
            List<Integer> levelList = new LinkedList<Integer>();
            for(int index =0; index <levelNumber; index++){
                if(nodesQueue.peek().left != null){
                    nodesQueue.offer(nodesQueue.peek().left);
                }
                if(nodesQueue.peek().right != null){
                    nodesQueue.offer(nodesQueue.peek().right);
                }
                levelList.add(nodesQueue.poll().val);
            }
            resultList.add(levelList);
        }
        return resultList;
    }
}
