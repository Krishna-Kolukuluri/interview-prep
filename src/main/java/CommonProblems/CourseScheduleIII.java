package CommonProblems;

import java.util.*;

/*
*
Each course at our university has at most one prerequisite that must be taken first.
* No two courses share a prerequisite.
* There is only one path through the program.
Write a function that takes a list of (prerequisite, course) pairs, and returns the name  of the course that the student
will be taking when they are halfway through their program.
(If a track has an even number of courses, and therefore has two "middle" courses,   you should return the first one.)
*
  Sample input 1: (arbitrarily ordered)
  const prereqs_courses1 = [
      ["Foundations of Computer Science", "Operating Systems"],
      ["Data Structures", "Algorithms"],
      ["Computer Networks", "Computer Architecture"],
      ["Algorithms", "Foundations of Computer Science"],
      ["Computer Architecture", "Data Structures"],
      ["Software Design", "Computer Networks"]
  ]

  In this case, the order of the courses in the program is:
      Software Design
      Computer Networks
      Computer Architecture
      Data Structures
      Algorithms
      Foundations of Computer Science
      Operating Systems

  Sample output 1:
      "Data Structures"
* */
public class CourseScheduleIII {
    static class Node{
        public Integer inDegrees = 0;
        public List<String> outNodes = new LinkedList<String>();
    }

    public static void main(String[] args) {
        String[][] prerequisitePairs = {{"Foundations of Computer Science", "Operating Systems"},
                                        {"Data Structures", "Algorithms"},
                                        {"Computer Networks", "Computer Architecture"},
                                        {"Algorithms", "Foundations of Computer Science"},
                                        {"Computer Architecture", "Data Structures"},
                                        {"Software Design", "Computer Networks"}};
        System.out.println(findMidPointCourse(prerequisitePairs));
    }
    private static String findMidPointCourse(String[][] prerequisites){
        int numCourses = 0;
        String[] topologicalOrder;
        HashMap<String, Node> graph = new HashMap<>();

        //Create/Build Graph
        for(String[] pair: prerequisites){
            Node prevCourse = getCreateNode(graph, pair[0]);
            Node nextCourse = getCreateNode(graph, pair[1]);
            prevCourse.outNodes.add(pair[1]);
            nextCourse.inDegrees++;
        }
        numCourses = graph.size();
        topologicalOrder = new String[numCourses];
        System.out.println(numCourses);

        //get all courses without any prerequisites.
        Queue<String> queue = new LinkedList<>();
        for(Map.Entry<String, Node> entry : graph.entrySet()){
            Node node = entry.getValue();
            if(node.inDegrees == 0){
                queue.offer(entry.getKey());
            }
        }

        //Find topological order among all courses.
        int index = 0;
        while (!queue.isEmpty()){
            String course = queue.poll();
            topologicalOrder[index] = course;
            index++;

            //Reduce neighbors indegree by 1.
            for(String nextCourse: graph.get(course).outNodes){
                Node node = graph.get(nextCourse);
                node.inDegrees--;
                if(node.inDegrees == 0){
                    queue.offer(nextCourse);
                }
            }
        }
        List<String> tpOrderList = Arrays.asList(topologicalOrder);
        System.out.println(tpOrderList);
        if(index == numCourses){
            //Topological order exists among course and prerequisite pairs.
            int midIndex = numCourses / 2;
            if(numCourses % 2 == 0){
                return topologicalOrder[midIndex-1];
            }else{
                return topologicalOrder[midIndex];
            }
        }
        return "";
    }

    private static Node getCreateNode(HashMap<String, Node> graph, String course) {
        Node node = null;
        if(graph.containsKey(course)){
            node = graph.get(course);
        }
        else{
            node = new Node();
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
