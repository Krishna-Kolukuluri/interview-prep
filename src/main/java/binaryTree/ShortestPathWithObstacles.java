package binaryTree;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/*
* https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
* You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down,
* left, or right from and to an empty cell in one step.

* Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1)
* given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
*
*Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation:
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
*
* Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.
* */
public class ShortestPathWithObstacles {
    /*
    * Like many grid search problems where the goal is to find the shortest path, the key to solve this problem is to
    * apply the Breadth-First Search algorithm, as opposed to the Depth-First Search (DFS) algorithm. In this article,
    * we will start with a classic BFS solution. Then on top of BFS, we will introduce a heuristic (greedy) strategy to
    * speed up the algorithm, which eventually transforms our classic BFS algorithm into another classic algorithm called
    * the A* search algorithm.
    * */
    public static int shortestPath(int[][] grid, int k){
        int rows = grid.length, cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};

        // if we have sufficient quotas to eliminate the obstacles in the worst case,
        // then the shortest distance is the Manhattan distance.
        if (k >= rows + cols - 2) {
            return rows + cols - 2;
        }

        Deque<StepState> queue = new LinkedList<>();
        HashSet<StepState> seen = new HashSet<>();

        // (steps, row, col, remaining quota to eliminate obstacles)
        StepState start = new StepState(0, 0, 0, k);
        queue.addLast(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            StepState curr = queue.pollFirst();

            // we reach the target here
            if (target[0] == curr.row && target[1] == curr.col) {
                return curr.steps;
            }

            int[] nextSteps = {curr.row, curr.col + 1, curr.row + 1, curr.col,
                    curr.row, curr.col - 1, curr.row - 1, curr.col};

            // explore the four directions in the next step
            for (int i = 0; i < nextSteps.length; i += 2) {
                int nextRow = nextSteps[i];
                int nextCol = nextSteps[i + 1];

                // out of the boundary of grid
                if (0 > nextRow || nextRow == rows || 0 > nextCol || nextCol == cols) {
                    continue;
                }

                int nextElimination = curr.k - grid[nextRow][nextCol];
                StepState newState = new StepState(curr.steps + 1, nextRow, nextCol, nextElimination);

                // add the next move in the queue if it qualifies.
                if (nextElimination >= 0 && !seen.contains(newState)) {
                    seen.add(newState);
                    queue.addLast(newState);
                }
            }
        }

        // did not reach the target
        return -1;
    }
    /*
    * Complexity Analysis
        Let N be the number of cells in the grid, and K be the quota to eliminate obstacles.
        Time Complexity: O(N⋅K)
        We conduct a BFS traversal in the grid. In the worst case, we will visit each cell in the grid. And for each cell,
        at most, it will be visited KK times, with different quotas of obstacle elimination.
        Thus, the overall time complexity of the algorithm is O(N⋅K).

        Space Complexity: O(N⋅K)
        We used a queue to maintain the order of visited states. In the worst case, the queue will contain the majority
        of the possible states that we need to visit, which in total is N⋅K as we discussed in the time complexity
        analysis. Thus, the space complexity of the queue is O(N⋅K).
        Other than the queue, we also used a set variable (named seen) to keep track of all the visited states along
        the way. Same as the queue, the space complexity of this set is also O(N⋅K).
        To sum up, the overall space complexity of the algorithm is O(N⋅K).
    * */

}
class StepState {
    /**
     * data object to keep the state info for each step:
     * <steps, row, col, remaining_eliminations>
     */
    public int steps, row, col, k;

    public StepState(int steps, int row, int col, int k) {
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;
    }

    @Override
    public int hashCode() {
        // needed when we put objects into any container class
        return (this.row + 1) * (this.col + 1) * this.k;
    }

    @Override
    public boolean equals(Object other) {
        /**
         * only (row, col, k) matters as the state info
         */
        if (!(other instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) other;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.row, this.col, this.k);
    }
}
