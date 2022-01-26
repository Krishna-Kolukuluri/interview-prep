package amazon.DynamicProgramming;

public class Palindrome {
    static boolean checkPalindrome(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
    
    static String longestPalindrome(String str){
        int maxLength = 1, start = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
     
        StringBuilder sb= new StringBuilder();
        for (int i = start; i <= start + maxLength - 1; ++i)
            sb.append(str.charAt(i));
        System.out.print("Longest palindrome subString is: "+sb.toString());
     
        return sb.toString();
    }
}
