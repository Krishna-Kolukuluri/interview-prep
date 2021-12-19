package recursion.backtracking;

import datastructures.models.Pair;
import java.util.HashSet;
import java.util.Set;

/*
*
You are controlling a robot that is located somewhere in a room. The room is modeled as an m x n binary grid where 0
* represents a wall and 1 represents an empty slot.

The robot starts at an unknown location in the root that is guaranteed to be empty, and you do not have access to the
* grid, but you can move the robot using the given API Robot.

You are tasked to use the robot to clean the entire room (i.e., clean every empty cell in the room). The robot with the
* four given APIs can move forward, turn left, or turn right. Each turn is 90 degrees.

When the robot tries to move into a wall cell, its bumper sensor detects the obstacle, and it stays on the current cell.

Design an algorithm to clean the entire room using the following APIs:
*
* */
/*
Spiral Backtracking pattern (backtracking + constrained programming).
constrained programming--> That basically means to put restrictions after visiting each cell and cleaning.
* */
public class RoboCleaner {
}
class RobotImpl{
    //Order of these directions is important as robot always moves up then  makes right turn if it can't move up.
    // it keeps taking right turn till it finds a cell to move-up
    // so the order should be up, right, down(right-right), left(right-right-right) from current facing position
    private int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private Set<Pair<Integer,Integer>> cellsVisited = new HashSet<>();
    private Robot robot;
    private void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    private void backtrack(int row, int col, int direction){
        cellsVisited.add(new Pair<>(row, col));
        robot.clean();

        for(int index=0;index<directions.length;index++){
            int nextCell = (direction + index)%4;
            int nextRow = row + directions[nextCell][0];
            int nextCol = col + directions[nextCell][1];
            if(!cellsVisited.contains(new Pair<>(nextRow, nextCol)) && robot.move()){
                backtrack(nextRow, nextCol, nextCell);
                goBack();
            }
            robot.turnRight();
        }
    }
    public void cleanRoom(Robot robot){
        this.robot = robot;
        backtrack(0,0,0);
    }
}
interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();
}
/*
*
Time complexity : O(N−M), where N is a number of cells in the room and M is a number of obstacles.

We visit each non-obstacle cell once and only once.
At each visit, we will check 4 directions around the cell. Therefore, the total number of operations would be 4⋅(N−M).
Space complexity : O(N−M), where N is a number of cells in the room and M is a number of obstacles.

We employed a hashtable to keep track of whether a non-obstacle cell is visited or not.
* */