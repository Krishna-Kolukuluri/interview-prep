package salesforce;

import java.util.*;

/**
 * Algorithm

    We will use a hash map to store the reference of the copy of all the nodes that have already been visited and copied. The key for the hash map would be the node of the original graph and corresponding value would be the corresponding cloned node of the cloned graph. The visited is used to prevent cycles and get the cloned copy of a node.

    Add the first node to the queue. Clone the first node and add it to visited hash map.

    Do the BFS traversal.

        Pop a node from the front of the queue.
        Visit all the neighbors of this node.
        If any of the neighbors was already visited then it must be present in the visited dictionary. Get the clone of this neighbor from visited in that case.
        Otherwise, create a clone and store in the visited.
        Add the clones of the neighbors to the corresponding list of the clone node.


Time Complexity : O(N + M)O(N+M), where NN is a number of nodes (vertices) and MM is a number of edges.

Space Complexity : O(N)O(N). This space is occupied by the visited dictionary and in addition to that, space would also be occupied by the queue since we are adopting the BFS approach here.
 The space occupied by the queue would be equal to O(W)O(W) where WW is the width of the graph. Overall, the space complexity would be O(N)O(N).
 */
public class CloneGraph {

 // Definition for a Node.
 class Node {
     public int val;
     public List<Node> neighbors;

     public Node() {}

     public Node(int _val,List<Node> _neighbors) {
         val = _val;
         neighbors = _neighbors;
     }
 };
     public Node cloneGraph(Node node) {
         if (node == null) {
             return node;
         }

         // Hash map to save the visited node and it's respective clone
         // as key and value respectively. This helps to avoid cycles.
         HashMap<Node, Node> visited = new HashMap();

         // Put the first node in the queue
         LinkedList<Node> queue = new LinkedList<Node> ();
         queue.add(node);
         // Clone the node and put it in the visited dictionary.
         visited.put(node, new Node(node.val, new ArrayList()));

         // Start BFS traversal
         while (!queue.isEmpty()) {
             // Pop a node say "n" from the from the front of the queue.
             Node n = queue.remove();
             // Iterate through all the neighbors of the node "n"
             for (Node neighbor: n.neighbors) {
                 if (!visited.containsKey(neighbor)) {
                     // Clone the neighbor and put in the visited, if not present already
                     visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                     // Add the newly encountered node to the queue.
                     queue.add(neighbor);
                 }
                 // Add the clone of the neighbor to the neighbors of the clone node "n".
                 visited.get(n).neighbors.add(visited.get(neighbor));
             }
         }

         // Return the clone of the node from visited.
         return visited.get(node);
     }
}