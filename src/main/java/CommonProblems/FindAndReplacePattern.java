package CommonProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
*
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the
answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the
pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no
two letters map to the same letter.
* Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.
*
* */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        MatchPattern matchPattern = new MatchPattern();
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(matchPattern.findAndReplace(words, pattern));
    }

}
class MatchPattern{
    public List<String> findAndReplace(String[] words, String pattern){
        List<String> patternMatchedWords =  new ArrayList<>();
        for(String word: words){
            if(matchPattern(word, pattern)){
                patternMatchedWords.add(word);
            }
        }
        return patternMatchedWords;
    }
    private boolean matchPattern(String word, String pattern){
        HashMap<Character, Character> wordMap = new HashMap<>();
        HashMap<Character, Character> patternMap = new HashMap<>();
        for(int index=0; index<word.length();index++){
            char w = word.charAt(index);
            char p = pattern.charAt(index);
            if(!wordMap.containsKey(w)){
                wordMap.put(w,p);
            }
            if(!patternMap.containsKey(p)){
                patternMap.put(p,w);
            }
            if(wordMap.get(w) != p || patternMap.get(p) != w){
                return false;
            }
        }
        return true;
    }
}
/*
*
Complexity Analysis
Time Complexity: O(N * K), where N is the number of words, and K is the length of each word.
Space Complexity: O(N * K), the space used by the answer.
*
* */
