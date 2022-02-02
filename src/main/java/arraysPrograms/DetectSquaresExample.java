package arraysPrograms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* https://leetcode.com/problems/detect-squares/
* https://leetcode.com/problems/detect-squares/discuss/1684103/Java-Simple-solution-beats-99-with-custom-wrapper-to-hide-Map-logic
*You are given a stream of points on the X-Y plane. Design an algorithm that:
Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
Given a query point, counts the number of ways to choose three points from the data structure such that the three points
and the query point form an axis-aligned square with positive area.
An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.
Implement the DetectSquares class:
DetectSquares() Initializes the object with an empty data structure.
void add(int[] point) Adds a new point point = [x, y] to the data structure.
int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.
* Example:
Input
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
Output
[null, null, null, null, 1, 0, null, 2]

Explanation
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // return 1. You can choose:
                               //   - The first, second, and third points
detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
detectSquares.count([11, 10]); // return 2. You can choose:
                               //   - The first, second, and third points
                               //   - The first, third, and fourth points
* */
/*
* Instead of trying to loop through every point that exists or every point that might exist we maintain the points in a
* two-layer HashMap. This lets us loop through ONLY the points which actually exist! We also can ignore all points except
* for one axis since there has to be a match on one of axis (in this case, X) in order to justify even checking the other axis.
* */
class DetectSquares {
    private PointMap pointMap;
    public DetectSquares(){
        pointMap = new PointMap();
    }

    public void add(int[] point){
        pointMap.addPoint(point[0], point[1]);
    }

    public int count(int[] point){
        int x1 = point[0];
        int y1 = point[1];
        int numOfSquares = 0;

        for(Map.Entry<Integer, Integer> point2: pointMap.getPoints(x1)){
            int y2 = point2.getKey();
            int countOfY2 = point2.getValue();
            if(y1 == y2){
                // Don't try to make squares with 0-length sides
                continue;
            }
            // No need to Math.abs() here - Doesn't really matter whether
            // this is positive or negative since we use both values
            int distance = y2 - y1;
            int x2 = x1 + distance;
            int x3 = x1 - distance;
            // Calculate how many squares can be constructed
            numOfSquares += countOfY2 * pointMap.getCountOfYForGivenX(x2, y1) * pointMap.getCountOfYForGivenX(x2, y2);
            numOfSquares += countOfY2 * pointMap.getCountOfYForGivenX(x3, y1) * pointMap.getCountOfYForGivenX(x3, y2);
        }
        return numOfSquares;
    }
}

// This class is just useful to isolate all the Map-traversal
// code rather than doing it all inline.
class PointMap{
    //Map to hold all points based on x coordinate and number of time same y coordinate being repeated for same x coordinate.
    private Map<Integer, Map<Integer, Integer>> points;
    public PointMap(){
        points = new HashMap<>();
    }

    //Adding points to pointsMap based on x as key and y as key and count
    public void addPoint(int x, int y){
        Map<Integer, Integer> yMap  = points.getOrDefault(x, new HashMap<Integer, Integer>());
        yMap.put(y, yMap.getOrDefault(y, 0)+1);
        points.put(x, yMap);
    }

    public int getCountOfYForGivenX(int x, int y){
        if(points.containsKey(x)){
            return points.get(x).getOrDefault(y, 0);
        }
        return 0;
    }

    public Set<Map.Entry<Integer, Integer>> getPoints(int x){
        if(points.containsKey(x)){
            return points.get(x).entrySet();
        }
        return new HashSet<>();
    }
}
public class DetectSquaresExample{
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3,10});
        detectSquares.add(new int[]{11,2});
        detectSquares.add(new int[]{3,2});
        System.out.println(detectSquares.count(new int[]{11,10}));
        System.out.println(detectSquares.count(new int[]{14,8}));
        detectSquares.add(new int[]{11,2});
        System.out.println(detectSquares.count(new int[]{11,10}));
    }
}
