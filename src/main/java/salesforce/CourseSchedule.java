package salesforce;

import java.util.*;

/**
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] 
 indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

        Example 1:
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: [0,1]
        Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

        Example 2:
        Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        Output: [0,2,1,3]
        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // course -> list of next courses
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

        // build the graph first
        for (int[] relation : prerequisites) {
            // relation[0] depends on relation[1]
            if (courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }

        boolean[] path = new boolean[numCourses];

        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            if (this.isCyclic(currCourse, courseDict, path)) {
                return false;
            }
        }

        return true;
    }


    /*
     * backtracking method to check that no cycle would be formed starting from currCourse
     */
    protected boolean isCyclic(
            Integer currCourse,
            HashMap<Integer, List<Integer>> courseDict,
            boolean[] path) {

        if (path[currCourse]) {
            // come across a previously visited node, i.e. detect the cycle
            return true;
        }

        // no following courses, no loop.
        if (!courseDict.containsKey(currCourse))
            return false;

        // before backtracking, mark the node in the path
        path[currCourse] = true;

        // backtracking
        boolean ret = false;
        for (Integer nextCourse : courseDict.get(currCourse)) {
            ret = this.isCyclic(nextCourse, courseDict, path);
            if (ret)
                break;
        }
        // after backtracking, remove the node from the path
        path[currCourse] = false;
        return ret;
    }
}
