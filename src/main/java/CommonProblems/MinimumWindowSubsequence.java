package CommonProblems;

/*
* Minimum Window Subsequence
* https://leetcode.com/problems/minimum-window-subsequence/
* https://leetcode.com/problems/minimum-window-subsequence/discuss/109362/Java-Super-Easy-DP-Solution-(O(mn))
* Given strings s1 and s2, return the minimum contiguous substring part of s1, so that s2 is a subsequence of the part.
* If there is no such window in s1 that covers all characters in s2, return the empty string "". If there are multiple
* such minimum-length windows, return the one with the left-most starting index.
* Example 1:
Input: s1 = "abcdebdde", s2 = "bde"
Output: "bcde"
Explanation:
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of s2 in the window must occur in order.
* Example 2:
Input: s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl", s2 = "u"
Output: ""
*
* */
public class MinimumWindowSubsequence {
    /*
    * figuring out what dp[i][j] means is keypoint:
    * dp[i][j] means: for S(0~i) & T(0~j), the "largest" starting index in S which matches T. I think share2017 didn't say
    * largest explicitly, some friends got confused in the comments for this. Since its the largest starting index, so
    * for String T with length 1, if it matches S(i), it should be index i.
    * */
    public static String minWindow(String s1, String s2) {
        int[][] M = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i ++){
            if(s1.charAt(i) == s2.charAt(0)){
                M[i][0] = i;        //  largest starting index matches only first char in T
            }else{
                if(i == 0){
                    M[i][0] = -1;    // S, T both have 1 char, if !match, fill -1 means we can't find a substring for S(0) & T(0)
                }else{
                    M[i][0] = M[i - 1][0];
                }
            }
        }
        for(int j = 1; j < s2.length(); j ++){
            for(int i = 0; i < s1.length(); i ++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i == 0){
                        M[i][j] = -1;       //  Actually, if j > i, M[i][j] is always -1, cause we cant find a substring of a shorter string matches a longer string
                    }else{
                        M[i][j] = M[i - 1][j - 1];  // As share2017 mentioned in his post
                    }
                }else{
                    if(i == 0){
                        M[i][j] = -1;
                    }else{
                        M[i][j] = M[i - 1][j];
                    }
                }
            }
        }
        int start = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < s1.length(); i ++){
            if(M[i][s2.length() - 1] != -1){
                if(i - M[i][s2.length() - 1] + 1 < len){
                    len = i - M[i][s2.length() - 1] + 1;
                    start = M[i][s2.length() - 1];
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s1.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s1 = "abcdebdde";
        String s2 = "bde";
        System.out.println(minWindow(s1, s2));
    }
}
