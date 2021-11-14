package ds.dstype.graphType.minimumspanningtree;

import java.util.PriorityQueue;
/*
“Kruskal’s algorithm” expands the “minimum spanning tree” by adding edges. Whereas “Prim’s algorithm” expands the
“minimum spanning tree” by adding vertices

* */
public class PrimsMstAlgorithm {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        PrimsMstAlgorithm solution = new PrimsMstAlgorithm();
        System.out.print("Minimum Cost to Connect Points = ");
        System.out.println(solution.minCostConnectPoints(points));
    }
    // Prim Algorithm
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        boolean[] visited = new boolean[size];
        int result = 0;
        int count = size - 1;
        // Add all edges from points[0] vertexs
        int[] coordinate1 = points[0];
        for (int j = 1; j < size; j++) {
            // Calculate the distance between two coordinates.
            int[] coordinate2 = points[j];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) +
                    Math.abs(coordinate1[1] - coordinate2[1]);
            Edge edge = new Edge(0, j, cost);
            pq.add(edge);
        }
        visited[0] = true;

        while (!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            int point1 = edge.point1;
            int point2 = edge.point2;
            int cost = edge.cost;
            if (!visited[point2]) {
                result += cost;
                visited[point2] = true;
                for (int j = 0; j < size; j++) {
                    if (!visited[j]) {
                        int distance = Math.abs(points[point2][0] - points[j][0]) +
                                Math.abs(points[point2][1] - points[j][1]);
                        pq.add(new Edge(point2, j, distance));
                    }
                }
                count--;
            }
        }
        return result;
    }
    class Edge {
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }
}
/*
V represents the number of vertices, and EE represents the number of edges.

Time Complexity: O(E⋅logV) for Binary heap, and O(E+V⋅logV) for Fibonacci heap.

For a Binary heap:
We need O(V+E) time to traverse all the vertices of the graph, and we store in the heap all the vertices that are not
yet included in our minimum spanning tree.
Extracting minimum element and key decreasing operations cost O(logV) time.
Therefore, the overall time complexity is O(V+E)⋅O(logV)=O(E⋅logV).
For a Fibonacci heap:
Extracting minimum element will take O(logV) time while key decreasing operation will take amortized O(1) time,
therefore, the total time complexity would be O(E+V⋅logV).
Space Complexity: O(V). We need to store VV vertices in our data structure.
* */
