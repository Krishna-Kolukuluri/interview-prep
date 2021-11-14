package ds.dstype.treeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Depth-First Search or Traversal of Binary Tree with Stack DS
public class InorderTraversal {
    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        depthFirstSearch(root, result);
        return result;
    }
    public void depthFirstSearch(TreeNode node, List<Integer> result){
        if(node != null){
            depthFirstSearch(node.left, result);
            result.add(node.val);
            depthFirstSearch(node.right, result);
        }
    }


    public List<Integer> inorderTraversalIter(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();
        TreeNode node = root;
        while (node != null || tempStack.size() > 0){
            if(node != null){
                tempStack.push(node);
                node = node.left;
            }
            else{
                node = tempStack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
