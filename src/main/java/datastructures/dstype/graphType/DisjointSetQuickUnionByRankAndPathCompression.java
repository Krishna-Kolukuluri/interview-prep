package datastructures.dstype.graphType;

public class DisjointSetQuickUnionByRankAndPathCompression {
    public static void main(String[] args){
        UnionByRankAndPathCompression urpc = new UnionByRankAndPathCompression(10);
        // 1-2-5-6-7 3-8-9 4
        urpc.union(1, 2);
        urpc.union(2, 5);
        urpc.union(5, 6);
        urpc.union(6, 7);
        urpc.union(3, 8);
        urpc.union(8, 9);
        System.out.println(urpc.connected(1, 5)); // true
        System.out.println(urpc.connected(5, 7)); // true
        System.out.println(urpc.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        urpc.union(9, 4);
        System.out.println(urpc.connected(4, 9)); // true
    }
}
class UnionByRankAndPathCompression{
    int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    int[] rank;
    public UnionByRankAndPathCompression(int size){
        root = new int[size];
        rank = new int[size];
        for(int index = 0; index<size; index++){
            root[index] = index;
            // The initial "rank" of each vertex is 1, because each of them is
            // a standalone vertex with no connection to other vertices.
            rank[index] = 1;
        }
    }

    //The find function locates the root node of a given vertex
    // The find function here is the same as that in the disjoint set with path compression.
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
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    //connected, which checks the “connectivity” of two vertices
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}

/*
Time Complexity
                 Union-find Constructor	Find	   Union	    Connected
Time Complexity	 O(N)     	            O(α(N))	   O(α(N))	    O(α(N))

Note: NN is the number of vertices in the graph. α refers to the Inverse Ackermann function. In practice,
we assume it's a constant. In other words,O(α(N)) is regarded as O(1) on average.

For the union-find constructor, we need to create two arrays of size NN each.
When using the combination of union by rank and the path compression optimization, the find operation will take
O(α(N)) time on average. Since union and connected both make calls to find and all other operations
require constant time, union and connected functions will also take O(α(N)) time on average.


Space Complexity
We need O(N) space to store the array of size N.
* */
