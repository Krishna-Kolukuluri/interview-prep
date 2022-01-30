package datastructures.dstype.stringType;

/*
https://leetcode.com/problems/implement-strstr/

Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
* */
public class StringIndexOf {
    public static void main(String[] args) {

    }
    public int getIndex(String haystack, String needle){

        if(needle.length() == 0 ){
            return 0;
        }
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        int i=0, j=0;
        int hLen = haystack.length();
        int nLen = needle.length();
        while(j < nLen && (i+j)<hLen){
            if(hChars[i+j] == nChars[j]){
                if(j == nLen - 1){
                    return i;
                }
                j++;
            }
            else{
                j = 0;
                i++;
            }
        }
        return -1;
    }
}
