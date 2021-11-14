package ds.dstype.graphType;

public class DisjointSetQuickUnionByRank {
    public static void main(String[] args){
        UnionByRank ubr = new UnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        ubr.unionByRank(1, 2);
        ubr.unionByRank(2, 5);
        ubr.unionByRank(5, 6);
        ubr.unionByRank(6, 7);
        ubr.unionByRank(3, 8);
        ubr.unionByRank(8, 9);
        System.out.println(ubr.connected(1, 5)); // true
        System.out.println(ubr.connected(5, 7)); // true
        System.out.println(ubr.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        ubr.unionByRank(9, 4);
        System.out.println(ubr.connected(4, 9)); // true
    }
}
class UnionByRank{
    int[] root;
    int[] rank;
    public UnionByRank(int size){
        root = new int[size];
        rank = new int[size];
        for(int index = 0; index<size; index++){
            root[index] = index;
            rank[index] = 1;
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
    public void unionByRank(int x, int y){
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
              Union-find Constructor	Find	  Union	     Connected
Time Complexity	        O(N)	        O(logN)	   O(logN)    O(logN)

Note: NN is the number of vertices in the graph.

For the union-find constructor, we need to create two arrays of size NN each.
For the find operation, in the worst-case scenario, when we repeatedly union components of equal rank, the tree height
will be at most log(N)+1, so the find operation requires O(logN) time.
For the union and connected operations, we also need O(logN) time since these operations are dominated by the find operation.
Space Complexity
We need O(N) space to store the array of size N.

* */