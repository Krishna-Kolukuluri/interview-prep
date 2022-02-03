package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Minimum Time Difference
* https://leetcode.com/problems/minimum-time-difference/
* https://leetcode.com/problems/minimum-time-difference/discuss/100636/Java-10-liner-solution.-Simplest-so-far
*Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
* Example 1:
Input: timePoints = ["23:59","00:00"]
Output: 1
* Example 2:
Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
* */
public class MinimumTimeDifference {
    //Time Complexity: O(N) + O(NlogN) + O(N) ~= O(NlogN + N)
    //Space Complexity: O(N). N is number of time points
    public static int findMinDifference(List<String> timePoints) {
        int mm = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<>();
        //Convert time points into minutes of the day
        for(int i = 0; i < timePoints.size(); i++){
            Integer h = Integer.valueOf(timePoints.get(i).substring(0, 2));
            time.add(60 * h + Integer.valueOf(timePoints.get(i).substring(3, 5)));
        }
        //Sort these minutes in ascending order
        Collections.sort(time, (a, b) -> Integer.compare(a,b));

        //Find minimum difference consecutive points in the list as the list is sorted.
        for(int i = 1; i < time.size(); i++){
            //System.out.println(time.get(i));
            mm = Math.min(mm, time.get(i) - time.get(i-1));
        }
        //Edge case for time point with 00:00 and last time in the list is 23:**
        int corner = time.get(0) + (1440 - time.get(time.size()-1));
        return Math.min(mm, corner);
    }

    public static void main(String[] args) {
        List<String> timePonts = new ArrayList<>(Arrays.asList("23:59","00:00"));
        System.out.println(findMinDifference(timePonts));

        timePonts = new ArrayList<>(Arrays.asList("00:00","23:59","00:00"));
        System.out.println(findMinDifference(timePonts));
    }
}
