package datastructures.dstype.stringType;

/*
Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
* */
public class CommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        longestCommonPrefix(strs);
    }
    public static String longestCommonPrefix(String[] strs){
        String ans = "";
        int idx = 0;

        int maxIdxAllowed = Integer.MAX_VALUE;
        boolean flag = true;

        for(int i=0;i<strs.length;i++){
            maxIdxAllowed = Math.min(maxIdxAllowed,strs[i].length());
        }

        while(idx<maxIdxAllowed){
            for(int i=0;i<strs.length-1;i++){
                if(strs[i].charAt(idx)!=strs[i+1].charAt(idx)){
                    flag = false;
                    break;
                }
            }
            if(flag==false){
                break;
            }
            idx++;
        }

        return strs[0].substring(0,idx);
    }
}
