package CommonProblems;

/*
* https://leetcode.com/problems/sentence-screen-fitting/
* https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution
* Given a rows x cols screen and a sentence represented as a list of strings, return the number of times the given
sentence can be fitted on the screen.
* The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single space must
separate two consecutive words in a line.
* Example 1:
Input: sentence = ["hello","world"], rows = 2, cols = 8
Output: 1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.
* Example 2:
Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
Output: 2
Explanation:
a-bcd-
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.
*
* */

public class ScreenFitting {
    /*
    * Time complexity: O(rows + n)
    * Space complexity: O(n)
    * */
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        //Joining all words into single string with space between each word and at the end of all words
        String s = String.join(" ", sentence) + " ";
        int start = 0, length = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % length) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % length) != ' ') {
                    start--;
                }
            }
        }
        return start / s.length();
    }
    /*
    * Algorithm:
    * This is a Greedy approach. Since we want to know how many times the given sentence can be fitted, we are actually
    * looking for the MAXIMUM time the given sentence can be fitted. Hance, we can try to put as many words in one line as
    * possible, making up the greedy approach. In this process, we first try to put as many words in one line as possible
    * and trim the tailing words that does not fit in that line as a whole, leaving all remaining positions in that line
    * after trimming empty (as space). Then we continue filling next line by starting from the word after the last word
    * in previous line. In this process we can make use of modulo operation to deal with the wrapping back issue for the sentence.

    Since there should be at least space between two words, we first add one space between each word and join the sentence.
    * Remember to add one space after the last word as well.

    Then we consider each row sequentially. Using start to represent the number of characters we have put. For each row,
    * we first try to put cols character from the joined sentence s into one line start from start (Maximum number of
    * characters we can put into this line). Then we check the next position after the last position of this line.
    There are 2 conditions:
    If the next position is a space, then this line can fit all words we put in, we add one to start according to the
    * implicit space in this case.
    If the next position is not space, we check for the current position. And we remove all characters that are not
    * space until we meet one since this last word we just removed cannot be fit in this line. In this process we
    * subtract 1 from start during each character being removed.
    At last, the start represents the length of the repeated lines in which each word is separated by exactly one space.
    * And since the joined sentence s has its words separated by 1 space as well, the number of repeats we can get is start / s.length().
    *
    * */


    public static void main(String[] args) {
        String[]sentence = new String[]{"i","had","apple","pie"};
        int rows = 4, cols = 5;
        System.out.println(wordsTyping(sentence, rows, cols));
    }
}
