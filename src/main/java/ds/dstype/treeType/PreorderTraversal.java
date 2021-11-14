package ds.dstype.treeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Depth-First Search or Traversal of Binary Tree with Stack DS
public class PreorderTraversal {
    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        depthFirstSearch(root, result);
        return result;
    }
    public void depthFirstSearch(TreeNode node, List<Integer> result){
        if(node != null){
            result.add(node.val);
            depthFirstSearch(node.left, result);
            depthFirstSearch(node.right, result);
        }
    }


    public List<Integer> preorderTraversalIter(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();
        if(root != null) {
            tempStack.push(root);
        }
        while (!tempStack.isEmpty()){
            TreeNode node = tempStack.pop();
            result.add(node.val);
            if(node.right != null){
                tempStack.push(node.right);
            }
            if(node.left != null){
                tempStack.push(node.left);
            }
        }
        return result;
    }
}
