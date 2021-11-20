package datastructures.dstype.graphType;

import java.util.*;

public class CloneGraph {
    //Depth-First Search/Traversal Approach.
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraphDfs(Node node){
        //Edge case
        if(node == null){
            return node;
        }
        //If the node is already visited before, return the cloned node from visited hashmap
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node cloneNode = new Node(node.val, new ArrayList());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);
        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for(Node neighbour: node.neighbors){
            cloneNode.neighbors.add(cloneGraphDfs(neighbour));
        }
        return cloneNode;
    }
    /*
    Complexity Analysis(DFS)
    Time Complexity: O(N+M), where N is a number of nodes (vertices) and M is a number of edges.
    Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that,
    space would also be occupied by the recursion stack since we are adopting a recursive approach here.
    The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph.
    Overall, the space complexity would be O(N).
    * */

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //Breadth-First Search
    public Node cloneGraphBfs(Node node){
        if(node == null){
            return node;
        }
        HashMap<Node, Node> visited = new HashMap();
        // Put the first node in the queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList<>()));
        // Start BFS traversal
        while (!queue.isEmpty()){
            // Pop a node say "n" from the from the front of the queue.
            Node n = queue.poll();
            // Iterate through all the neighbors of the node "n"
            for(Node neighbour: n.neighbors){
                if(!visited.containsKey(neighbour)){
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
                    // Add the newly encountered node to the queue.
                    queue.offer(neighbour);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbour));
            }
        }
        // Return the clone of the node from visited.
        return visited.get(node);
    }

}
