package patterns.general;

import java.util.Arrays;
import java.util.LinkedList;

/*
* https://leetcode.com/problems/design-hashset/
* Design a HashSet without using any built-in hash table libraries.
Implement MyHashSet class:
void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
* */
public class DesignHashset {

}
/*
*Complexity Analysis:
Time Complexity: O(N/K) where N is the number of all possible values and K is the number of predefined buckets, which is 769.
Assuming that the values are evenly distributed, thus we could consider that the average size of bucket is N/K
Since for each operation, in the worst case, we would need to scan the entire bucket, hence the time complexity is O(N/K).
Space Complexity: O(K+M) where K is the number of predefined buckets, and M is the number of unique values that have been inserted into the HashSet.
* */
class MyHashSetImplWithLinkedList{
    private Bucket[] buckets;
    private int keyRange; //Having large enough prime number will result in less collisions
    public MyHashSetImplWithLinkedList(){
        keyRange = 769;
        buckets = new BucketLinkedList[keyRange];
        Arrays.stream(buckets).forEach(bucket-> bucket = new BucketLinkedList());
    }
    private int hash(int key){
        return  key % keyRange;
    }
    public void add(int key){
        int bucketIndex = hash(key);
        buckets[bucketIndex].insert(key);
    }

    public void remove(int key){
        int bucketIndex = hash(key);
        buckets[bucketIndex].delete(key);
    }

    public boolean contains(int key){
        int bucketIndex = hash(key);
        return buckets[bucketIndex].exists(key);
    }
}
class BucketLinkedList implements Bucket{
    private LinkedList<Integer> bucket;
    public BucketLinkedList(){
        bucket = new LinkedList<>();
    }

    @Override
    public boolean exists(Integer key) {
        int index = bucket.indexOf(key);
        return index != -1;
    }

    @Override
    public void insert(Integer key) {
        int index = bucket.indexOf(key);
        if(index == -1){
            bucket.addFirst(key);
        }
    }

    @Override
    public void delete(Integer key) {
        bucket.remove(key);
    }
}

/*
* Complexity Analysis:
Time Complexity: O( log N/K) where N is the number of all possible values and K is the number of predefined buckets, which is 769.
Assuming that the values are evenly distributed, thus we could consider that the average size of bucket is N/K
When we traverse the BST, we are conducting binary search, as a result, the final time complexity of each operation is O(log N/K).
Space Complexity: O(K+M) where K is the number of predefined buckets, and M is the number of unique values that have been inserted into the HashSet.
*
* */
class MyHashSetImlWithBST{
    private Bucket[] buckets;
    private int keyRange; //Having large enough prime number will result in less collisions
    public MyHashSetImlWithBST(){
        keyRange = 769;
        buckets = new BucketBST[keyRange];
        Arrays.stream(buckets).forEach(bucket-> bucket = new BucketLinkedList());
    }
    private int hash(int key){
        return  key % keyRange;
    }
    public void add(int key){
        int bucketIndex = hash(key);
        buckets[bucketIndex].insert(key);
    }

    public void remove(int key){
        int bucketIndex = hash(key);
        buckets[bucketIndex].delete(key);
    }

    public boolean contains(int key){
        int bucketIndex = hash(key);
        return buckets[bucketIndex].exists(key);
    }
}
class BucketBST implements Bucket{
    private BSTree tree;

    public BucketBST(){
        tree = new BSTree();
    }

    @Override
    public boolean exists(Integer key) {
        TreeNode node = tree.searchBST(tree.root, key);
        return node != null;
    }

    @Override
    public void insert(Integer key) {
        tree.root = tree.insertIntoBST(tree.root, key);
    }

    @Override
    public void delete(Integer key) {
        tree.root = tree.deleteNode(tree.root, key);

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class BSTree {
    TreeNode root = null;

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val)
            return root;

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val > root.val)
            // insert into the right subtree
            root.right = insertIntoBST(root.right, val);
        else if (val == root.val)
            // skip the insertion
            return root;
        else
            // insert into the left subtree
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    /*
     * One step right and then always left
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    /*
     * One step left and then always right
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        // delete from the right subtree
        if (key > root.val)
            root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null)
                root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}

interface Bucket{
    boolean exists(Integer key);
    void insert(Integer key);
    void delete(Integer key);
}
