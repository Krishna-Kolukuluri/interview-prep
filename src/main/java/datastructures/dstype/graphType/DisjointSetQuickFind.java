package datastructures.dstype.graphType;

//quick find implementation of the Disjoint Set.
//The primary use of disjoint sets is to address the connectivity between the components of a network
public class DisjointSetQuickFind {
    public static void main(String[] args){
        QuickFind quickFind = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        quickFind.union(1, 2);
        quickFind.union(2, 5);
        quickFind.union(5, 6);
        quickFind.union(6, 7);
        quickFind.union(3, 8);
        quickFind.union(8, 9);
        System.out.println(quickFind.connected(1,5));
        System.out.println(quickFind.connected(5,7));
        System.out.println(quickFind.connected(4,9));
        // 1-2-5-6-7 3-8-9-4
        quickFind.union(9, 4);
        System.out.println(quickFind.connected(4,9));
    }
}
//Disjoint Set --> quick find implementation
class QuickFind {
    private int[] root;

    public QuickFind(int size){
        root = new int[size];
        for(int index = 0; index < size; index++){
            root[index] = index;
        }
    }

    //The find function locates the root node of a given vertex
    public int quickFind(int x){
        return root[x];
    }

    //The union function connects two previously unconnected vertices by giving them the same root node.
    public void union(int x , int y){
        int rootX = quickFind(x);
        int rootY = quickFind(y);
        if(rootX != rootY){
            for(int index =0; index < root.length; index++){
                if(root[index] == rootY){
                    root[index] = rootX;
                }
            }
        }
    }

    //connected, which checks the “connectivity” of two vertices
    public boolean connected(int x, int y){
        return quickFind(x) == quickFind(y);
    }
}


/*
Time Complexity
Union-find Constructor	Find	Union	Connected
Time Complexity	O(N)	O(1)	O(N)	O(1)

Note: NN is the number of vertices in the graph.

When initializing a union-find constructor, we need to create an array of size NN with the values equal to the
corresponding array indices; this requires linear time.
Each call to find will require O(1) time since we are just accessing an element of the array at the given index.
Each call to union will require O(N) time because we need to traverse through the entire array and update the root
vertices for all the vertices of the set that is going to be merged into another set.
The connected operation takes O(1) time since it involves the two find calls and the equality check operation.


Space Complexity
We need O(N) space to store the array of size N
* */

