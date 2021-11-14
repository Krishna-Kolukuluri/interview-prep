package CommonProblems;

import java.util.HashMap;

public class CipherProblem {


    public static void main(String[] args) {
    }

    public static String solution(String word, String cipher){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        //String cipher =   "mpgzkeyrsxfwlvjbcnuidhoqat";
        HashMap<Character, Character> cipherMap = new HashMap<>();
        HashMap<Character, Character> ciphers = new HashMap<>();
        if(cipher.length() != 26){
            return "";
        }
        for(int index=0; index< alphabet.length() - 1; index++){
            if(ciphers.containsKey(cipher.charAt(index))){
                return "";
            }
            else{
                ciphers.put(cipher.charAt(index), cipher.charAt(index));
            }
            cipherMap.put(alphabet.charAt(index), cipher.charAt(index));
        }
        String result = "";
        //String word = "";
        for(int index=0;index<word.length() -1; index++){
            if(alphabet.indexOf(word.charAt(index)) == -1){
                return "";
            }
            result = result + cipherMap.get(word.charAt(index));
        }
        return result;
    }

}
