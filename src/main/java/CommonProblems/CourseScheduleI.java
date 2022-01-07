package CommonProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*
Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
*
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
* */
public class CourseScheduleI {
    public static void main(String[] args) {
        int numOfCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(canFinishCourses(numOfCourses, prerequisites));
        prerequisites = new int[][] {{1,0}};
        System.out.println(canFinishCourses(numOfCourses, prerequisites));
    }
    public static boolean canFinishCourses(int numCourses, int[][] prerequisites){
        if(prerequisites.length == 0){
            return true; //no cycle could be formed in empty graph.
        }
        //course -> list<nextCourses> mapping.
        HashMap<Integer, GNode> graph = new HashMap<>();
        //build the graph with nodes and edges
        for(int[] edge: prerequisites){
            //Mapping is edge[1] precedes edge[0] due to given prerequisite constraint.
            GNode prevCourse = getCreateGNode(graph, edge[1]);
            GNode nextCourse = getCreateGNode(graph, edge[0]);
            prevCourse.outNodes.add(edge[0]);
            nextCourse.inDegrees++;
        }

        //Find courses with no prerequisites, these are the ones we start with for finding topological sort.
        int totalEdges = prerequisites.length;
        LinkedList<Integer> noDepCourses = new LinkedList<>();
        for(Map.Entry<Integer, GNode> entry: graph.entrySet()){
            GNode node = entry.getValue();
            if(node.inDegrees == 0){
                noDepCourses.offer(entry.getKey());
            }
        }

        //Remove edges which are already visited to find topological order if one exists or there will be a cycle in the
        //Graph.
        Integer removedEdges = 0;
        while(noDepCourses.size() > 0){
            Integer course = noDepCourses.poll();
            for(Integer nextCourse: graph.get(course).outNodes){
                GNode childNode = graph.get(nextCourse);
                childNode.inDegrees--;
                removedEdges++;
                if(childNode.inDegrees == 0){
                    noDepCourses.offer(nextCourse);
                }
            }
        }

        if(removedEdges != totalEdges){
            // if there are still some edges left, then there exist some cycles
            // Due to the dead-lock (dependencies), we cannot remove the cyclic edges
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Retrieve the existing <key, value> from graph, otherwise create a new one.
     */
    private static GNode getCreateGNode(HashMap<Integer, GNode> graph, int course) {
        GNode node = null;
        if(graph.containsKey(course)){
            node  = graph.get(course);
        }else{
            node = new GNode();
            graph.put(course, node);
        }
        return node;
    }
}
class GNode{
    public Integer inDegrees = 0;
    public List<Integer> outNodes = new LinkedList<Integer>();
}

/*
Note that we could use different types of containers, such as Queue, Stack or Set, to keep track of the nodes that have
no incoming dependency, i.e. indegree = 0. Depending on the type of container, the resulting topological order would be
different, though they are all valid.

Complexity

Time Complexity: O(∣E∣+∣V∣) where ∣V∣ is the number of courses, and ∣E∣ is the number of dependencies.

As in the previous algorithm, it would take us ∣E∣ time complexity to build a graph in the first step.
Similar with the above postorder DFS traversal, we would visit each vertex and each edge once and only once in the worst case, i.e. ∣E∣+∣V∣.
As a result, the overall time complexity of the algorithm would be O(2⋅∣E∣+∣V∣)=O(∣E∣+∣V∣).

Space Complexity: O(∣E∣+∣V∣), with the same denotation as in the above time complexity.

We built a graph data structure in the algorithm, which would consume ∣E∣+∣V∣ space.
In addition, we use a container to keep track of the courses that have no prerequisite, and the size of the container would be bounded by ∣V∣.
As a result, the overall space complexity of the algorithm would be O(∣E∣+2⋅∣V∣)=O(∣E∣+∣V∣).
* */