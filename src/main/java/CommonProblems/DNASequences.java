package CommonProblems;

import java.util.*;

/*
*
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more
than once in a DNA molecule. You may return the answer in any order.
*
* Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
* Output: ["AAAAACCCCC","CCCCCAAAAA"]
*
* Input: s = "AAAAAAAAAAAAA"
* Output: ["AAAAAAAAAA"]
* */
public class DNASequences {
    //Not most efficient implementation
    /*
    Complexity Analysis
    Time complexity : O((N−L)L), that is O(N) for the constant L=10. In the loop executedN−L+1 one builds a substring of
    length L. Overall that results in O((N−L)L) time complexity.
    Space complexity : \mO((N−L)L) to keep the hashset, that results in O(N) for the constant L = 10.
    * */
    public List<String> findRepeatedDnaSequencesSlidingWindow(String s) {
        int L = 10, n = s.length();
        HashSet<String> seen = new HashSet(), output = new HashSet();

        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            String tmp = s.substring(start, start + L);
            if (seen.contains(tmp)) output.add(tmp);
            seen.add(tmp);
        }
        return new ArrayList<String>(output);
    }



    /*
    https://leetcode.com/problems/repeated-dna-sequences/solution/
     Rabin-Karp : Constant-time Slice Using Rolling Hash
    * */
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (n <= L) return new ArrayList();

        // rolling hash parameters: base a
        int a = 4, aL = (int)Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

        int h = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute hash of the current sequence in O(1) time
            if (start != 0)
                h = h * a - nums[start - 1] * aL + nums[start + L - 1];
                // compute hash of the first sequence in O(L) time
            else
                for(int i = 0; i < L; ++i) h = h * a + nums[i];
            // update output and hashset of seen sequences
            if (seen.contains(h)) output.add(s.substring(start, start + L));
            seen.add(h);
        }
        return new ArrayList<String>(output);
    }
    /*
    Complexity Analysis
    Time complexity : O(N−L), that is O(N) for the constant L = 10. In the loop
    executed N−L+1 one builds a hash in a constant time, that results in O(N−L) time complexity.

    Space complexity : O(N−L) to keep the hashset, that results in O(N) for the constant L=10.
    * */
}
