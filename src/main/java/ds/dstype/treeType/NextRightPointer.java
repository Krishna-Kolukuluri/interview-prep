package ds.dstype.treeType;

//Populating Next Right Pointers in Each Node
//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
// The binary tree has the following definition:
public class NextRightPointer {
    public NextNode connectBalancedBinaryTree(NextNode root) {
        if(root == null) return root;

        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null){
            root.right.next = root.next != null ? root.next.left : null;
        }

        connectBalancedBinaryTree(root.left);
        connectBalancedBinaryTree(root.right);
        return root;
    }

    public NextNode connectBinaryTree(NextNode root) {
        NextNode dummyHead  = new NextNode(0); // this head will always point to the first element in the current layer we are searching
        NextNode pre = dummyHead; // this 'pre' will be the "current node" that builds every single layer
        NextNode real_root = root; // just for return statement

        while(root != null){
            if(root.left != null){
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right != null){
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if(root == null){ // reach the end of current layer
                pre = dummyHead; // shift pre back to the beginning, get ready to point to the first element in next layer
                root = dummyHead.next; ;//root comes down one level below to the first available non null node
                dummyHead.next = null;//reset dummyhead back to default null
            }
        }
        return real_root;
    }
}
