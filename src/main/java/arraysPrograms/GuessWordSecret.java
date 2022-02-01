package arraysPrograms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* https://leetcode.com/problems/guess-the-word/
* https://leetcode.com/problems/guess-the-word/discuss/1729589/Java-with-comments
* This is an interactive problem.
You are given an array of unique strings wordlist where wordlist[i] is 6 letters long, and one word in this list is chosen as secret.
You may call Master.guess(word) to guess a word. The guessed word should have type string and must be from the original list with 6 lowercase letters.
This function returns an integer type, representing the number of exact matches (value and position) of your guess to the
secret word. Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have exactly 10 guesses to guess the word. At the end of any number of calls, if you have made
10 or fewer calls to Master.guess and at least one of these guesses was secret, then you pass the test case.
Example 1:
Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"], numguesses = 10
Output: You guessed the secret word correctly.
Explanation:
master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
*
Example 2:
Input: secret = "hamada", wordlist = ["hamada","khaled"], numguesses = 10
Output: You guessed the secret word correctly.
* */
public class GuessWordSecret {
    public void findSecretWord(String[] wordlist, Master master) {

        Set<String> words = new HashSet<>();
        for (String word : wordlist) {
            words.add(word);
        }

        if (words.size() <= 10) {
            // if words size is less than 10, then we can just guess all the words in the list
            words.stream().forEach(master::guess);
            return;
        }

        Set<String> visited = new HashSet<>();
        Set<String> partialMatches = new HashSet<>();

        // run max 10 times
        for (int i = 10; i >= 0; i--) {

            for (String word : words) {

                // if there are no partial matches yet, we want to consider the selected word
                boolean matched = partialMatches.isEmpty() ? true : false;

                // if there are partial matches, only consider the word if it has at least one character
                // in that partial match word list
                for (String possibleWord : partialMatches) {
                    for (int j = 0; j < possibleWord.length(); j++) {
                        if (word.charAt(j) == possibleWord.charAt(j)) {
                            matched = true;
                            break;
                        }
                    }
                }

                // mark the word as visited so we don't guess it again
                visited.add(word);

                if (!matched) {
                    // no character in the selected word matches any char in partial matches.
                    continue;
                }

                int guess = master.guess(word);

                if (guess == 0) {
                    // none of the characters matched their positions
                    // remove all words for whom these characters are the same place. they won't be our secret anyways
                    removeEntries(words, word);
                    break;
                }

                if (guess != 6) {
                    // some indexes matched. not sure which one. add it to possible matches list
                    partialMatches.add(word);
                }

                if (guess == 6) {
                    // all positions matched
                    return;
                }
            }

            // remove already guessed or unmatched words
            words.removeAll(visited);
        }

    }

    // remove all words for whom these characters are the same place. they won't be our secret anyways
    private void removeEntries(Set<String> words, String removableWord) {
        int index = 0;
        for (char ch : removableWord.toCharArray()) {
            Iterator<String> itr = words.iterator();
            while (itr.hasNext()) {
                String word = itr.next();
                if (word.charAt(index) == ch) {
                    itr.remove();
                }
            }
            index++;
        }
    }
}
interface Master {
      public int guess(String word);
}
