package shopify;

public class RobotDirections {

    
    public static void main(String[] args)
    {
        String move = "UDDLLRUUUDUURUDDUULLDRRRR";
        System.out.println(judgeCircle("GGLLGG"));
        System.out.println(isRobotBounded("GGLLGG"));
    }
    //Robot starting at 0,0 and after moves check if x and y are 0,0 
    //returns true if x and y are 0,0 at the end
    //Wrong output
    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
    
//    Input: instructions = "GGLLGG"
//            Output: true
//            Explanation: The robot is initially at (0, 0) facing the north direction.
//            "G": move one step. Position: (0, 1). Direction: North.
//            "G": move one step. Position: (0, 2). Direction: North.
//            "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
//            "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
//            "G": move one step. Position: (0, 1). Direction: South.
//            "G": move one step. Position: (0, 0). Direction: South.
//            Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
//            Based on that, we return true.
    
//    Input: instructions = "GG"
//            Output: false
//            Explanation: The robot is initially at (0, 0) facing the north direction.
//            "G": move one step. Position: (0, 1). Direction: North.
//            "G": move one step. Position: (0, 2). Direction: North.
//            Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
//            Based on that, we return false.
    
    
//    Time complexity: \mathcal{O}(N)O(N), where NN is a number of instructions to parse.

//    Space complexity: \mathcal{O}(1)O(1) because the array directions contains only 4 elements.
        public static boolean isRobotBounded(String instructions) {
            // north = 0, east = 1, south = 2, west = 3
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            // Initial position is in the center
            int x = 0, y = 0;
            // facing north
            int idx = 0;
            
            for (char i : instructions.toCharArray()) {
                if (i == 'L')
                    idx = (idx + 3) % 4;
                else if (i == 'R')
                    idx = (idx + 1) % 4;
                else {
                    x += directions[idx][0];
                    y += directions[idx][1];   
                }    
            }
            
            // after one cycle:
            // robot returns into initial position
            // or robot doesn't face north
            return (x == 0 && y == 0) || (idx != 0);
        }
}
