package arraysPrograms;

import java.util.*;

public class SimilarOrders {

    
    public static void main(String args[]){
        List<String> x = new ArrayList<>();
        x.add("nnbnnb");
        x.add("ammxdf");
        List<String> y = new ArrayList<>();
        y.add("bbncbb");
        y.add("aecxdf");
        List<String> result = new ArrayList<>();
        for(int i=0;i<x.size();i++){
            result.add(similarorders(x.get(i),y.get(i)));
        }
        for(String res:result){
            System.out.println(res);
        }
    }
    static String similarorders(String str1,String str2){
        int l1 = str1.length();
        int l2 = str2.length();
        if(l1 != l2){
            return "NO";
        }else{
            int maxChars = 26;
            
            int exists[] = new int[maxChars];
            for (int i = 0; i < maxChars; i++)
            {
                exists[i] = 0;
            }
            for (int i = 0; i < l1; i++)
            {
                exists[str1.charAt(i) - 'a'] = 1;
            }
            for (int i = 0; i < l2; i++)
            {
                if (exists[str2.charAt(i) - 'a'] == 1
                    || exists[str2.charAt(i) - 'a'] == -1)
                {
                    exists[str2.charAt(i) - 'a'] = -1;
                }
                else
                {
                    exists[str2.charAt(i) - 'a'] = 2;
                }
            }
            int count=0;
            for (int i = 0; i < maxChars; i++)
            {
                if (exists[i] == 1 || exists[i] == 2)
                {
                    count++;
                }
            }
            if(count>=3){
                return "NO";
            }
            else return "YES";
            
        }
        
        
    }
}
