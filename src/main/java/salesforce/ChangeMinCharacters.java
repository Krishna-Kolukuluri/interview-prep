package salesforce;

/**
You are given two strings a and b that consist of lowercase letters. In one operation, you can change any character in a or b to any lowercase letter.

Your goal is to satisfy one of the following three conditions:

Every letter in a is strictly less than every letter in b in the alphabet.
Every letter in b is strictly less than every letter in a in the alphabet.
Both a and b consist of only one distinct letter.
Return the minimum number of operations needed to achieve your goal.

Example 1:
        Input: a = "aba", b = "caa"
        Output: 2
        Explanation: Consider the best way to make each condition true:
        1) Change b to "ccc" in 2 operations, then every letter in a is less than every letter in b.
        2) Change a to "bbb" and b to "aaa" in 3 operations, then every letter in b is less than every letter in a.
        3) Change a to "aaa" and b to "aaa" in 2 operations, then a and b consist of one distinct letter.
        The best way was done in 2 operations (either condition 1 or condition 3).
Example 2:
        Input: a = "dabadd", b = "cda"
        Output: 3
        Explanation: The best way is to make condition 1 true by changing b to "eee".
 */

public class ChangeMinCharacters {

    public int minCharacters(String a, String b) {
        int ans = Integer.MAX_VALUE;
        
        //WE call the make method for first two conditions. First call makes a smaller than b and second one makes b smaller than a.
        ans = Math.min(make(a,b),make(b,a));
        
        //This is for the 3rd conditions. We count the steps to make the strings contain only one distinct character.
        for(char ch='a';ch<='z';ch++){
            
            int total = a.length() + b.length();
            
            for(char c:a.toCharArray())
                if(c==ch)
                    total--;
            for(char c:b.toCharArray())
                if(c==ch)
                    total--;
            
            ans = Math.min(total,ans);
            
        }
        
        
        return ans;
    }
    
    //This method checks for the first two conditions
    //For given string a and b, we try to make a smaller than b . We count the no of steps needed to make a smaller than b . We return the minimum value for it.
    public int make(String a, String b){
        
        int local = Integer.MAX_VALUE;
        
        for(char ch='b';ch<='z';ch++){
            
            int temp = 0;
            for(char c:a.toCharArray()){
                if(c>=ch)
                    temp++;
            }
            
            for(char c:b.toCharArray()){
                if(c<ch)
                    temp++;
            }
            local = Math.min(local,temp);
            
        }
        
        return local;
    }
    
}
