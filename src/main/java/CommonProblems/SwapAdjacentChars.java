package CommonProblems;
/*
* Swap Adjacent in LR String
* https://leetcode.com/problems/swap-adjacent-in-lr-string/
* https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/113789/Simple-Java-one-pass-O(n)-solution-with-explaination
*
* In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one
* occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the
* ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
* Example 1:
Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: true
Explanation: We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
* Example 2:
Input: start = "X", end = "L"
Output: false
*
* */
public class SwapAdjacentChars {
    public static boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;   // The lengths must match because we can't add/remove characters.

        int startIdx = 0, endIdx = 0;
        // Keep going as long as there are characters that we can process.
        while (startIdx < start.length() || endIdx < end.length()) {
            // Find next non-'X' chraracter in start.
            while (startIdx < start.length() && start.charAt(startIdx) == 'X') {
                startIdx++;
            }
            // Find next non-'X' chraracter in end.
            while (endIdx < end.length() && end.charAt(endIdx) == 'X') {
                endIdx++;
            }

            // Return false if one reached the end but the other one didn't.
            if (startIdx == start.length() || endIdx == end.length()) {
                return startIdx == start.length() && endIdx == end.length();
            }
            assert (start.charAt(startIdx) != 'X' && end.charAt(endIdx) != 'X');

            // The current two characters must match in content.
            if (start.charAt(startIdx) != end.charAt(endIdx)) return false;
            // We must be able to use the given two operations (move 'L' to the left, move 'R' to the right) to make them
            // match in position (move start.charAt(startIdx) from startIdx to endIdx).
            if (start.charAt(startIdx) == 'L' && startIdx < endIdx) return false;    // We can't move an 'L' to the right.
            if (start.charAt(startIdx) == 'R' && startIdx > endIdx) return false;    // We can't move an 'R' to the left.

            startIdx++; endIdx++;   // We succesfully matched start.charAt(startIdx) to end.charAt(endIdx).
        }
        return true;   // No more characters to process so we return true since we managed to match ALL non-'X' characters.
    }

    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        System.out.println(canTransform(start, end));
        start = "R";
        end = "L";
        System.out.println(canTransform(start, end));
    }
}
