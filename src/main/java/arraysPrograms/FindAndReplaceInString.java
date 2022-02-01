package arraysPrograms;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/find-and-replace-in-string/
* https://leetcode.com/problems/find-and-replace-in-string/discuss/1727428/Java-1-beats-99-store-sources-in-a-HashMap-very-clear-code-with-comments
* You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are
* given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.

To complete the ith replacement operation:
Check if the substring sources[i] occurs at index indices[i] in the original string s.
If it does not occur, do nothing.
Otherwise, if it does occur, replace that substring with targets[i].
For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".

All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing
of each other. The testcases will be generated such that the replacements will not overlap.

For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
Return the resulting string after performing all replacement operations on s.

A substring is a contiguous sequence of characters in a string.
* */
public class FindAndReplaceInString {
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        StringBuilder sb = new StringBuilder(); // what we'll return, via toString()

        Map<Integer, Integer> stringIndexToKIndex = new HashMap<>();
        for (int i = 0; i < indices.length; ++i) {
            stringIndexToKIndex.put(indices[i], i);
        }
        for (int indexIntoS = 0; indexIntoS < s.length(); ++indexIntoS) {
            if (stringIndexToKIndex.containsKey(indexIntoS)) {
                String substringInSources = sources[stringIndexToKIndex.get(indexIntoS)];
                if (indexIntoS + substringInSources.length() <= s.length()) {
                    String substringInS = s.substring(indexIntoS, indexIntoS + substringInSources.length());
                    if (substringInS.equals(substringInSources)) {
                        sb.append(targets[stringIndexToKIndex.get(indexIntoS)]);
                        indexIntoS += substringInS.length() - 1; // make sure we advance the length of the substring in `s` that was replaced
                    } else { // substrings don't match
                        sb.append(s.charAt(indexIntoS));
                    }
                } else { // `s` isn't long enough to match substring in `sources`
                    sb.append(s.charAt(indexIntoS));
                }
            } else { // index in `s` isn't in `sources`
                sb.append(s.charAt(indexIntoS));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0,2};
        String[] sources = new String[]{"a", "cd"};
        String[] targets = new String[]{"eee", "ffff"};
        System.out.println(findReplaceString(s, indices, sources, targets));
    }
}
