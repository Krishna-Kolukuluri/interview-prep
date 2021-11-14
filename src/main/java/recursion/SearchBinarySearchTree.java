package recursion;

public class SearchBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val){
        if(root == null || root.val == val){
            return root;
        }
        return searchBST(root.val < val  ? root.right: root.left, val);
    }

    public TreeNode searchBSTLessMem(TreeNode root, int val) {
        if(root==null) return root;
        if(root.val == val) return root;
        else if(root.val < val) return searchBSTLessMem(root.right,val);
        else return searchBSTLessMem(root.left,val);
    }
}
