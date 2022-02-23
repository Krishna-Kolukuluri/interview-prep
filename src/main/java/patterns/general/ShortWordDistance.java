package patterns.general;

import java.util.Map;

/*
*
* Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return
* the shortest distance between these two words in the list.
* Example 1:
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3
* Example 2:
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
* */
public class ShortWordDistance {
    public static void main(String[] args) {
        String[] wordDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word1= "coding";
        String word2 = "practice";
        System.out.println(shortestDistance(wordDict, word1, word2));
        wordDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        word1= "makes";
        word2 = "coding";
        System.out.println(shortestDistance(wordDict, word1, word2));
    }
    private static int shortestDistance(String[] wordsDict, String word1, String word2){
        int wordOneIdx = -1;
        int wordTwoIdx = -1;
        int minDistance  = Integer.MAX_VALUE;
        for(int i=0; i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                wordOneIdx = i;
            }
            if(wordsDict[i].equals(word2)){
                wordTwoIdx = i;
            }
            if(wordOneIdx != -1 && wordTwoIdx != -1){
                minDistance = Math.min(minDistance, Math.abs(wordOneIdx - wordTwoIdx));
            }
        }
        return minDistance;
    }
}
