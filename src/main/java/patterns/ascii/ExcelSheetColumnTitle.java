package patterns.ascii;

/*
* https://leetcode.com/problems/excel-sheet-column-title/
* Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

Example 1:
Input: columnNumber = 1
Output: "A"
*
Example 2:
Input: columnNumber = 28
Output: "AB"
*
Example 3:
Input: columnNumber = 701
Output: "ZY"
* */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(701));
    }
    public static String convertToTitle(int columnNumber) {
        return columnNumber == 0 ? "" : convertToTitle(--columnNumber / 26) + (char)('A' + (columnNumber % 26));
    }
}
