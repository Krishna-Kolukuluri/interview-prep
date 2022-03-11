package salesforce;

public class RepeatedSubString {
    
    /**
    Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
    
    Example 1:
    Input: s = "abab"
    Output: true
    Explanation: It is the substring "ab" twice.
    
    Example 2:
    Input: s = "aba"
    Output: false
    **/
    public boolean repeatedSubstringPattern(String str) {
        //This is the kmp issue
        int[] prefix = kmp(str);
        int len = prefix[str.length()-1];
        int n = str.length();
        return (len > 0 && n%(n-len) == 0);
    }
    private int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while(i < ch.length && j < ch.length){
            if(ch[j] == ch[i]){
                res[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    res[j] = 0;
                    j++;
                }else{
                    i = res[i-1];
                }
            }
        }
        return res;
    }

}
