package CommonProblems;
/*
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing
spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the
sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.
Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
* */
public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
        int[] values = new int[]{8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(values));

    }
    public static int maxScoreSightseeingPair(int[] values) {
        int maxValue = Math.max(values[0], values[1] + 1);
        int score = values[1] + values[0] - 1;
        for(int i = 2; i < values.length; i++){
            score = Math.max(score, maxValue + values[i] - i);
            maxValue = Math.max(maxValue, values[i] + i);
        }
        return score;
    }
}
