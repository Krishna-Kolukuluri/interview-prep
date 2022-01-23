package CommonProblems;

import java.util.Arrays;

/*
*
You are given a string with a special compressed format, your task is to decompress it.
The given string will look like XXXX[0xFF, L, O]XXX, where ‘X' represents a char (a-z), [0xFF, L, O] represents the
compressed part, where 0xFF is a tag that shows this is the compressed region, O is offset chars you will need to move
backward, and L is the length of chars you will need to take (see below example for clearer explanation)

Ex:
Given abcd[0xFF, 1, 2]xy, you need to output: abcdcxy. The additional 'c' between 'd' and 'x' comes from: O = 2,
means you need to move 2 chars backward from 'd' (inclusive), which land us at 'c', and L = 1, menas we take 1 char, which is 'c'.
Thus we end up with abcdcxy.

Given abcd[0xFF, 1, 2]xy[0xFF, 3, 3], you need to output abcdcxycxy.
* */
public class StringDecompression {
    public static void main(String[] args) {
        Decompress decompress =  new Decompress();
        String str = "abcd[0xFF, 1, 2]xy[0xFF, 3, 3]";
        System.out.println(decompress.decompress(str));
        str = "abcd[0xFF, 1, 2]xy";
        System.out.println(decompress.decompress(str));
    }
}
class Decompress{
    //TC O(N)
    public String decompress(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char[] result = new char[chars.length];
        int j = 0;
        boolean encoded = false;

        for(int i=0; i< chars.length; i++){
            if(chars[i] != '[' && !encoded){
                result[j]= chars[i];
                j++;
            }
            else {
                encoded = true;
                if(!Character.isWhitespace(chars[i])){
                    if(chars[i] != ']'){
                        sb.append(chars[i]);
                    }
                }
            }
            if(chars[i] == ']'){
                encoded = false;
                String[] offsetStr = sb.toString().split(",");
                int offset = Integer.parseInt(String.valueOf(offsetStr[offsetStr.length - 1]));
                int length = Integer.parseInt(String.valueOf(offsetStr[offsetStr.length - 2]));
                int start = j - offset;
                int end = start + length;
                sb = new StringBuilder();
                char[] temp = Arrays.copyOf(result, chars.length);
                for(int m = start; m<end; m++){
                    result[j++] = temp[m];
                }
            }
        }
        return String.valueOf(result);
    }
}
