package datastructures.dstype.graphType;

public class DisjointSetQuickUnion {
    public static void main(String[] args) throws Exception{
        QuickUnion qu = new QuickUnion(10);
        // 1-2-5-6-7 3-8-9 4
        qu.quickUnion(1, 2);
        qu.quickUnion(2, 5);
        qu.quickUnion(5, 6);
        qu.quickUnion(6, 7);
        qu.quickUnion(3, 8);
        qu.quickUnion(8, 9);
        System.out.println(qu.connected(1, 5)); // true
        System.out.println(qu.connected(5, 7)); // true
        System.out.println(qu.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        qu.quickUnion(9, 4);
        System.out.println(qu.connected(4, 9)); // true
    }
}
class QuickUnion{
    private int[] root;
    public QuickUnion(int size){
        root = new int[size];
        for(int index = 0; index<size; index++){
            root[index] = index;
        }
    }
    //The find function locates the root node of a given vertex
    public int find(int x){
        while (x != root[x]){
            x = root[x];
        }
        return x;
    }
    //The union function connects two previously unconnected vertices by giving them the same root node.
    public void quickUnion(int x, int y){
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
Union-find Constructor	Find	Union	Connected
Time Complexity	O(N)	O(log N)	O(log N)	O(log N)

Note: NN is the number of vertices in the graph. In the worst-case scenario, the number of operations to get the root
vertex will be HH where HH is the height of the tree, however, because this implementation always points the root of the
shorter tree to the root of the taller tree HH will be at most logN.

The same as in the quick find implementation, when initializing a union-find constructor, we need to create an array
of size N with the values equal to the corresponding array indices; this requires linear time.
For the find operation, in the worst-case scenario, we need to traverse every vertex to find the root for the input vertex.
The maximum number of operations to get the root vertex would be no more than the tree's height, so it will take O(logN) time.
The union operation consists of two find operations which take O(logN) time each, and two constant time operations,
including the equality check and updating the array value at a given index. Therefore, the union operation also costs O(logN).
The connected operation also takes O(logN) time since it involves two find calls.


Space Complexity
We need O(N) space to store the array of size N.

* */