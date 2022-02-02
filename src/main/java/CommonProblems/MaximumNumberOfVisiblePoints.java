package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* https://leetcode.com/problems/maximum-number-of-visible-points/ maximum number of visible points
* https://leetcode.com/problems/maximum-number-of-visible-points/discuss/877845/JAVA-Sliding-Window
*
* */
public class MaximumNumberOfVisiblePoints {
    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        //Integer[][] points = new Integer[][]{{2,1},{2,2},{3,3}};
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> point = new ArrayList<>(Arrays.asList(2,1));
        points.add(point);
        point = new ArrayList<>(Arrays.asList(2,2));
        points.add(point);
        point = new ArrayList<>(Arrays.asList(3,3));
        points.add(point);

        int angle = 90;
        Integer[] location = new Integer[]{1,1};

        System.out.println(visiblePoints(points, angle, Arrays.asList(location)));
    }
}
