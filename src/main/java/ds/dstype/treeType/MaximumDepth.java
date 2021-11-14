package ds.dstype.treeType;

public class MaximumDepth {
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int ans = 1;
    public int maxDepthTopDownBottomUp(TreeNode root) {
        if (root == null)
            return 0;
        //topDown(root, ans);
        return bottomUp(root);
        //return ans;
    }

    public void topDown(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            ans = Math.max(ans, depth);
        topDown(root.left, depth + 1);
        topDown(root.right, depth + 1);
    }

    public int bottomUp(TreeNode root) {
        if (root == null)
            return 0;
        int left_d = bottomUp(root.left);
        int right_d = bottomUp(root.right);
        return Math.max(left_d, right_d) + 1;
    }

}
