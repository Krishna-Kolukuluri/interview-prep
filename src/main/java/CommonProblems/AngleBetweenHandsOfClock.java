package CommonProblems;
/*
*
Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
Answers within 10^-5 of the actual value will be accepted as correct.
*
Input: hour = 12, minutes = 30
Output: 165
*
Input: hour = 3, minutes = 30
Output: 75
*
Input: hour = 3, minutes = 15
Output: 7.5
* */
public class AngleBetweenHandsOfClock {
    public static void main(String[] args) {
        System.out.println(getAngle(12, 30));
        System.out.println(getAngle(3, 30));
    }

    public  static double getAngle(int hour, int minutes){
        int oneMinAngle = 6;
        int oneHourAngle = 30;

        double minutesAngle = oneMinAngle * minutes;
        double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

        double diff = Math.abs(hourAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }
}
/*
Complexity Analysis
Time complexity : O(1).
Space complexity : O(1).
* */