package datastructures.dstype.treeType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Depth-First Search or Traversal of Binary Tree with Stack and LinkedList DS
public class PostorderTraversal {
    public List<Integer> postorderTraversalRec(TreeNode root){
        List<Integer> result = new ArrayList<>();
        depthFirstSearch(root, result);
        return result;
    }
    public void depthFirstSearch(TreeNode node, List<Integer> result){
        if(node != null){
            depthFirstSearch(node.left, result);
            depthFirstSearch(node.right, result);
            result.add(node.val);
        }
    }


    public List<Integer> postorderTraversalIter(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> tempStack = new Stack<>();
        if(root != null) {
            tempStack.push(root);
        }

        while (!tempStack.isEmpty()){
            TreeNode node = tempStack.pop();
            result.addFirst(node.val);
            if(node.left != null){
                tempStack.push(node.left);
            }
            if(node.right != null){
                tempStack.push(node.right);
            }
        }
        return result;
    }
}
