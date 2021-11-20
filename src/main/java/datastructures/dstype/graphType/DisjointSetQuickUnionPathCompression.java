package datastructures.dstype.graphType;

public class DisjointSetQuickUnionPathCompression {
    public static void main(String[] args){
        UnionPathCompression upc = new UnionPathCompression(10);
        //1-2-5-6-7 3-8-9 4
        upc.union(1, 2);
        upc.union(2, 5);
        upc.union(5, 6);
        upc.union(6, 7);
        upc.union(3, 8);
        upc.union(8, 9);
        System.out.println(upc.connected(1, 5)); // true
        System.out.println(upc.connected(5, 7)); // true
        System.out.println(upc.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        upc.union(9, 4);
        System.out.println(upc.connected(4, 9)); // true
    }
}
//Path Compression Optimization - Disjoint Sets
// After finding the root node, we can update the parent node of all traversed elements to their root node.
// When we search for the root node of the same element again, we only need to traverse two elements to find its root node, which is highly efficient.
class UnionPathCompression{
    int[] root;
    public UnionPathCompression(int size){
        root = new int[size];
        for(int index = 0; index<size; index++){
            root[index] = index;
        }
    }
    //The find function locates the root node of a given vertex
    public int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }
    //The union function connects two previously unconnected vertices by giving them the same root node.
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            root[rootY] = rootX;
        }
    }
    //connected, which checks the “connectivity” of two vertices
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}

/*
Time Complexity
Time complexities shown below are for the average case, since the worst-case scenario is rare in practice.

Union-find Constructor	Find	Union	Connected
Time Complexity	O(N)	O(logN)	O(logN)	O(logN)

Note: NN is the number of vertices in the graph.

As before, we need O(N) time to create and fill the root array.
For the find, union, and connected operations (the latter two operations both depend on the find operation),
we need O(1) time for the best case (when the parent node for some vertex is the root node itself).
In the worst case, it would be O(N) time when the tree is skewed. However, on average, the time complexity will be O(logN).
Supporting details for the average time complexity can be found in Top-Down Analysis of Path Compression
where R. Seidel and M. Sharir discuss the upper bound running time when path compression is used with arbitrary linking.
Space Complexity
We need O(N) space to store the array of size N.

*/
