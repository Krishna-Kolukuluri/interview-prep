package CommonProblems;

import java.util.Arrays;
import java.util.List;

/*
*
Longest Common Subsequence.
* Longest repeating pattern for two users
Two patterns are given, one for each user. Find the longest repeating pattern for both users.
User1: ["hi", "bye", "hello", "leetcode", "start", "end"]
User2: ["hi", "stop", "leetcode", "start", "end", "bye"]

Output: ["leetcode", "start", "end"]
Only solution I could think of is O(nm). Simply iterate through each string in first user and check if you find a match
in the second user. What's a better way to go about this? Couldn't find a similar problem in leetcode
*
* */
public class LongestCommonPattern {
    public static void main(String[] args) {
        String[] userOne = {"hi", "bye", "hello", "leetcode", "start", "end"};
        String[] userTwo = {"hi", "stop", "leetcode", "start", "end", "bye"};
        System.out.println(longestRepeatPattern(userOne,userTwo));
    }

    private static List<String> longestRepeatPattern(String[] userOne, String[] userTwo){
        //Tabulation /DP bottom-up approach.
        int[][] dp = new int[userOne.length+1][userTwo.length+1];
        int maxPatternLen = 0;
        int endIndexInUserOne = -1;
        for(int i=1;i<=userOne.length;i++){
            for(int j=1;j<=userTwo.length;j++){
                if(userOne[i-1].equals(userTwo[j-1])){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j]>maxPatternLen){
                        maxPatternLen = dp[i][j];
                        endIndexInUserOne = i;
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        List<String> pattern = Arrays.asList(userOne).subList(endIndexInUserOne-maxPatternLen, endIndexInUserOne);
        return pattern;
    }
}
/*
*
Time Complexity: O(N * M) N is length of userOne array, M is length of userTwo array.
Space Complexity: O(N * M) for DP memoization.
*
* */
