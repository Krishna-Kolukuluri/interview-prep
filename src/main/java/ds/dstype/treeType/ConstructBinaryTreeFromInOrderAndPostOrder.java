package ds.dstype.treeType;

import java.util.HashMap;

//Construct Binary Tree from Inorder and Postorder Traversal
public class ConstructBinaryTreeFromInOrderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode helper(int postOrderEnd, int inOrderStart, int inOrderEnd, int[] inorder, int[] postorder){

        // 1. Base case.
        if (postOrderEnd < 0 || inOrderStart > inOrderEnd) return null;

        // 2. Build a node.
        TreeNode cur = new TreeNode(postorder[postOrderEnd]);

        // 3. Find the pivot in the inorder.
        int inOrderPivot = 0;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == postorder[postOrderEnd]){
                inOrderPivot = i;
                break;
            }
        }

        // 4. return the node.
        cur.left  = helper(postOrderEnd + inOrderPivot - inOrderEnd - 1,
                            inOrderStart,
                   inOrderPivot - 1,
                            inorder, postorder);
        cur.right = helper(postOrderEnd - 1,
                inOrderPivot + 1,
                          inOrderEnd, inorder, postorder);
        return cur;
    }

    //Simple to understand  and Faster
    int idx;
    public TreeNode buildTreeWithMap(int[] inorder, int[] postorder) {

        idx = postorder.length-1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return rec(map, postorder, 0, inorder.length-1);
    }

    private TreeNode rec(HashMap<Integer, Integer> map, int[] postorder, int left, int right){

        if(left > right) return null;

        int r = map.get(postorder[idx]);
        TreeNode root = new TreeNode(postorder[idx--]);

        root.right = rec(map, postorder, r+1, right);
        root.left = rec(map, postorder, left, r-1);

        return root;
    }
}
