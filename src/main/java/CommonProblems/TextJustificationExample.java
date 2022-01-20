package CommonProblems;

import java.util.ArrayList;
import java.util.List;

/*
*
* https://leetcode.com/problems/text-justification/
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters
and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces
' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not
divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
*
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
* */
public class TextJustificationExample {
    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        TextJustify textJustify = new TextJustify();
        List<String> justifiedStrings = textJustify.fullJustify(words, maxWidth);
        System.out.println(justifiedStrings);
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        justifiedStrings = textJustify.fullJustify(words, maxWidth);
        System.out.println(justifiedStrings);
    }
}
class TextJustify{
    public TextJustify(){

    }
    public List<String> fullJustify(String[] words, int maxWidth){
        int lineStart = 0;
        int lineEnd;
        List<String> result = new ArrayList<>();
        while (lineStart < words.length){
            lineEnd = findLineEnd(words, lineStart, maxWidth);
            result.add(justifyLine(lineStart, lineEnd, words, maxWidth));
            lineStart = lineEnd + 1;
        }
        return result;
    }

    private int findLineEnd(String[] words, int lineStart, int maxWidth){
        int lineEnd = lineStart;
        int charCount = words[lineEnd].length();
        lineEnd++;
        int space = 1;
        while (lineEnd < words.length && (charCount + space + words[lineEnd].length())<=maxWidth){
            charCount += space + words[lineEnd].length();
            lineEnd++;
        }
        return  lineEnd - 1;
    }
    private String justifyLine(int lineStart, int lineEnd, String[] words, int maxWidth){
        if(lineStart - lineEnd == 0) {
            return padSpace(words[lineStart], maxWidth);
        }
        boolean isLastLine = lineEnd == words.length - 1;
        int numOfSpacesInCurrLine = lineEnd - lineStart;
        int totalSpacesNeeded = maxWidth - lineTextLength(words, lineStart, lineEnd);
        String spacing = isLastLine?" ":blank(totalSpacesNeeded/numOfSpacesInCurrLine);
        int remainingSpaces = isLastLine?0:totalSpacesNeeded%numOfSpacesInCurrLine;
        StringBuilder result = new StringBuilder();
        for(int i=lineStart; i<=lineEnd;i++){
            result.append(words[i]).append(spacing).append(remainingSpaces-- > 0?" ":"");
        }
        return padSpace(result.toString().trim(), maxWidth);
    }

    private int lineTextLength(String[] words, int lineStart, int lineEnd){
        int curLineTextLength = 0;
        for(int i=lineStart;i <= lineEnd; i++){
            curLineTextLength += words[i].length();
        }
        return curLineTextLength;
    }

    private String padSpace(String lineText, int maxWidth){
        return lineText + blank(maxWidth - lineText.length());
    }

    private String blank(int length){
        return new String(new char[length]).replace('\0',' ');
    }
}
/*
We start with LineStart being the first word.

findLineEnd: Then we greedily try to go as far right as possible until we fill our current line.

Then we justifyLine one line at a time.

justifyLine: In all cases we pad the right side with spaces until we reach max width for the line;

If it's one word then it is easy, the result is just that word.
If it's the last line then the result is all words separated by a single space.
Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space until it is gone.
*
* */