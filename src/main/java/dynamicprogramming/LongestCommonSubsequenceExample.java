package dynamicprogramming;

/*
*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common
subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted
* without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*
* */

public class LongestCommonSubsequenceExample {
    public static void main(String[] args) {

        CommonSubsequence commonSubsequence = new CommonSubsequence();
        String text1 = "abcde", text2= "ace";
//        int sequenceLength = commonSubsequence.lengthOfCommonSubsequence(text1,text2);
//        System.out.println(sequenceLength);
//
//        text1 = "abc";
//        text2= "abc";
//       sequenceLength = commonSubsequence.lengthOfCommonSubsequence(text1,text2);
//        System.out.println(sequenceLength);

        text1 = "oxcpqrsvwf";
        text2= "shmtulqrypy";
        int sequenceLength = commonSubsequence.lengthOfCommonSubsequence(text1,text2);
        System.out.println(sequenceLength);
    }
}
class CommonSubsequence{

    public String text1 ;
    public String text2;
    public int[][] memo ;
    public CommonSubsequence(){
    }
    public int lengthOfCommonSubsequence(String text1, String text2){
        this.text1 = text1;
        this.text2 = text2;
        memo = new int[text1.length()+1][text2.length()+1];
        // We need to initialise the memo array to -1's so that we know
        // whether or not a value has been filled in. Keep the base cases
        // as 0's to simplify the later code a bit.
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                this.memo[i][j] = -1;
            }
        }
        int length = memoSolve(0,0);//findLength(0,0);
        System.out.println(length);
        return length;
    }

/*
*
Time complexity : O(M. N^2)
Space complexity : O(M⋅N).
* *
* */
    //Top-Down DP
    public int findLength(int p1, int p2){
        //Checking if this subsequence already visited or not
        if(memo[p1][p2] != -1){
            return memo[p1][p2];
        }

        //Considering char at p1(in text1) is not part of text2 and moving to next char.
        int optionOne = findLength(p1+1, p2);

        //Getting index of char in text2 after p2 index in text2 if yet a there is one.
        int firstOccurrenceOfCharInText2 = text2.indexOf(text1.charAt(p1), p2);
        int optionTwo = 0;
        if(firstOccurrenceOfCharInText2 != -1){
            optionTwo = 1 + findLength(p1+1, firstOccurrenceOfCharInText2+1);
        }
        memo[p1][p2] = Math.max(optionOne, optionTwo);
        return memo[p1][p2];
    }

    /*
    *
    *
    Time complexity : O(M⋅N).

    This time, solving each subproblem has a cost of O(1). Again, there are M⋅N subproblems, and so we get a total time
    complexity of O(M⋅N).

    Space complexity : O(M⋅N).
    We need to store the answer for each of the M⋅N subproblems.
    *
    * */
    private int memoSolve(int p1, int p2){
        //Base case
        if(memo[p1][p2] != -1){
            return memo[p1][p2];
        }
        int length = 0;
        if(text1.charAt(p1) == text2.charAt(p2)){
            length = 1 + memoSolve(p1+1, p2+1);
        }else{
            length = Math.max(memoSolve(p1, p2+1), memoSolve(p1+1, p2));
        }

        memo[p1][p2] = length;
        return memo[p1][p2];
    }
}
