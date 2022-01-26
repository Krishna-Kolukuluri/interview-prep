package arraysPrograms;

import java.util.*;

public class NGramString {
    public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        for (int i = 0; i < str.length() - n + 1; i++)
            // Add the substring or size n
            ngrams.add(str.substring(i, i + n));
        // In each iteration, the window moves one step forward
        // Hence, each n-gram is added to the list

        return ngrams;
    }

    public static void main(String args[]) {
        String str = "abcdef";
        List<String> ngrams = ngrams(3, str);
        for (String ngram : ngrams) {
            System.out.println(ngram);
        }
    }
}
