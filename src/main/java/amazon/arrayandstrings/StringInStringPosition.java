package amazon.arrayandstrings;

public class StringInStringPosition {
    public static void main(String args[]) {
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","baa"));
        System.out.println(strStr("",""));
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.length()==0||needle.length()==0)
            return 0;
        if(haystack.contains(needle)){
            for(int i=0;i<haystack.length();i++){
                if(haystack.charAt(i) == needle.charAt(0)){
                    if(haystack.substring(i, i+needle.length()).equals(needle))
                        return i;
                }
            } 
        }
        return -1;
    }
}
