package arraysPrograms;

import java.util.*;

public class MaxOccuringSubStringOfString {

    // Function to return maximum
    // occurred subString of a String
    static String MaxFreq(String str) {
        // Size of the String
        int n = str.length();

        Map<String, Integer> mp = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = i; j < n; j++) {
                s += str.charAt(j);
                if (mp.containsKey(s)) {
                    mp.put(s, mp.get(s) + 1);
                } else {
                    mp.put(s, 1);
                }
            }
        }

        // To store maximum frequency
        int maxi = 0;

        // To store String which
        // has maximum frequency
        String s = "";
        for (Map.Entry<String, Integer> i : mp.entrySet()) {
            if (i.getValue() > maxi) {
                maxi = i.getValue();
                s = i.getKey();
            } else if (i.getValue() == maxi) {
                String ss = i.getKey();
                if (ss.length() > s.length())
                    s = ss;
            }
        }

        // Return subString which
        // has maximum frequency
        return s;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "ababecdecd";

        // Function call
        System.out.print(MaxFreq(str));
    }
}
