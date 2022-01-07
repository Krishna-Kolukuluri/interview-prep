package CommonProblems;

import java.util.*;

/*
*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
If it is impossible to finish all courses, return an empty array.
*
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
* */
public class CourseScheduleII {
    static class  GNode{
        public Integer inDegrees = 0;
        public List<Integer> outNodes = new LinkedList<Integer>();
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        List<Integer> result = Arrays.asList(findOrderOfCourses(numCourses, prerequisites));
        System.out.println(result);
    }
    public static Integer[] findOrderOfCourses(int numCourses, int[][] prerequisites){
        if(prerequisites.length == 0){
            return new Integer[0]; //no courses can be taken from empty list.
        }
        HashMap<Integer, GNode> graph= new HashMap<>();
        Integer[] topologicalOrder = new Integer[numCourses];

        //Create/Build graph from prerequisites.
        for(int[] edge: prerequisites){
            GNode prevCourse = getCreateNode(graph, edge[1]);
            GNode nextCourse = getCreateNode(graph, edge[0]);
            prevCourse.outNodes.add(edge[0]);
            nextCourse.inDegrees++;
        }

        //Find nodes with inDegree == 0 i.e. courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, GNode> entry: graph.entrySet()){
            GNode node = entry.getValue();
            if(node.inDegrees == 0){
                queue.offer(entry.getKey());
            }
        }

        //Process all nodes from queue till queue becomes empty
        int index = 0;
        while (!queue.isEmpty()){
            Integer course = queue.poll();
            topologicalOrder[index] = course;
            index++;
            //Reduce indegrees of each neighbor of course by 1.
            if(graph.containsKey(course)){
                for(Integer nextCourse: graph.get(course).outNodes){
                    GNode node = graph.get(nextCourse);
                    node.inDegrees--;
                    if(node.inDegrees == 0){
                        queue.offer(nextCourse);
                    }
                }
            }
        }
        if(index == numCourses){
            return topologicalOrder;
        }
        return new Integer[0];
    }

    private static GNode getCreateNode(HashMap<Integer, GNode> graph, int course) {
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
