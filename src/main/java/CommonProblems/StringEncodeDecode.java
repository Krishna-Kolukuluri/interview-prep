package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is
decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

You are not allowed to solve the problem using any serialize methods (such as eval).
* */
public class StringEncodeDecode {
    public static void main(String[] args) {
        Encode en = new  Encode();
        Decode de = new Decode();
        List<String> strs = new ArrayList<>(Arrays.asList("Hello","World"));
        String enStr = en.encode(strs);
        System.out.println(enStr);
        System.out.println(de.decode(enStr));
    }
}
/*
Complexity Analysis
Time complexity : O(N) both for encode and decode, where N is a number of strings in the input array.
Space complexity : O(1) for encode to keep the output, since the output is one string. O(N) for decode keep the output,
since the output is an array of strings.
* */
class Encode{
    public String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(intToString(str));
            sb.append(str);
        }
        return sb.toString();
    }

    private String intToString(String s){
        int x = s.length();
        char[] bytes = new char[4];
        for(int i = 3; i > -1; i --){
            //0xff equal to 255 in unsigned decimal, -127 in signed decimal, and 11111111 in binary
            /*
            * Understanding bytes = [chr(x >> (i * 8) & 0xff) for i in range(4)]
            all you need to do is encode the length of x into 4 bytes ( why 4 bytes - integer size - 4 bytes = [8bits, 8bits, 8bits, 8bits])

            ok so how do you get a X(length of str) total size into chunks of 8 bits ?
            2.1 >> is right shift - which means if you have 101111 >> 2 - this right shift moves 101111, 2 times to the right - which
            becomes 1011
            2.2 if you go to python terminal and type 0xff you get 8 1's which represents 11111111 = a BYTE
            2.3 if you AND(&) any number with 0xff = it gives you the right most 8 bits of the number
            example: 1. bin(291) (binary of 291) is '0b100100011'
            2. oxff binary is '0b11111111'
            3. now if you 291 & 0xff = you get last 8 bits of 291 == 00100011
            If you understand this - you understood the solution.

            Now as explained in the 2 point. The python solution line 6 we take the whole length of the string (len(str)) - we have to
            encode that into [8bits, 8 bits, 8bits, 8bits]
            example: 1. lets say our total length is 291 ( in binary its bin(291) = '0b100100011')
            2. what you have to do now ? we grab the right most 8 bits - how do you grab right most 8 bits ?
            2.1 as mentioned above you do 291 & 0xff = you get last 8 bits

            Now you already have right most 8 bits - in next iteration you are interested in NEXT 8 bits - how do you get
            that ? we move 291 >> 8 ( which removes the last 8 bits we already computed) - which means if you do
            (291 >> 8 ) & 0xff = it gives you the next right most 8 bits

            as already mentioned we need 4 chunks of 8 bits [8bits, 8bits, 8bits, 8bits]
            4.1 [ for i in range(4)] thats why the range is 4 ( 0, 1, 2, 3)

            Once you compute all the 8bits we need to convert to char hence its [chr((x >> (i * 8)) & 0xff) for i in range(4)]
            * */
            bytes[3 -i] = (char)(x >> (i * 8) & 0xff);
        }
        return new  String(bytes);
    }
}
class Decode{
    //Decode single string to list of strings
    public List<String> decode(String s){
        int i = 0;
        int n = s.length();
        List<String> output = new ArrayList<>();
        while(i<n){
            int length = stringToInt(s.substring(i, i+4));
            i += 4;
            output.add(s.substring(i, i+ length));
            i += length;
        }
        return  output;
    }

    private int stringToInt(String bytesStr){
        int result = 0;
        for(char b: bytesStr.toCharArray()){
            result = (result << 8)  + (int)b;
        }
        return result;
    }
}