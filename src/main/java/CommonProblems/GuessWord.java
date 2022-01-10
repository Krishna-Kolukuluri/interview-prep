package CommonProblems;

import java.util.*;

/*
*
* https://leetcode.com/discuss/interview-question/1432943/google-phone-screen-rejected
You need to guess a word . The word will be there in a master list .
You are provided with a list of Words and number of character match at the right position .
Example
input {{"MOXTE",3} , {"AXCDG",0},{"MOQRT",2},{"FOUSE",4},{"POWER",1}
return  "MOUSE"
*
Solved using DFS
Algorithm:-
1. Start with index 0. Let your answer be a ""(Empty) string. Assume a max variable which will define a length for you final answer. (It can be the length of any input word that we have)
2. Create a map of letter and the remaining count if the letter is removed from word.
For ex. If we see letter 'M', the entry set would be ('M', {2,0,1,4,1}). Initial count was {3,0,2,4,1}. 'M' existed in first and third word at index 0, so we subtracted one from it.
3. Repeat Step 2 for all distinct letters at current index value. (For, 'F' and 'P' too)
4. Now for each entry in the HashMap, increase the index by 1, append the map's current key (the letter, For Ex. 'M') to 'answer' ,and repeat from Step 2.
5. Repeat Step 3 until, length of answer = max && the sum of the counts remaining is zero. This will be your answer that perfectly matches your condition.
6. Return from DFS, if length of answer >= max. (i.e. if the max length is reached, we can return from DFS as we cannot find any further solution for these combinations)
*
*  */
public class GuessWord {
    static String word = "";
    private static void dfs(String answer, int[] counts, String[] options, int charIndex, int max){
        if(answer.length() == max){
            if(Arrays.stream(counts).sum() == 0){
                word = answer;
            }
            return;
        }
        HashMap<Character, int[]> map = new HashMap<>();
        for(int index = 0; index < options.length; index++){
            if(counts[index] > 0){
                int[] countsClone = counts.clone();
                char ch = options[index].charAt(charIndex);
                if(map.containsKey(ch)){
                    countsClone = map.get(ch);
                }
                countsClone[index] = countsClone[index] - 1;
                map.put(ch, countsClone);
            }
        }
        for(Map.Entry<Character, int[]> entry: map.entrySet()){
            dfs(answer+entry.getKey(), entry.getValue(), options, charIndex + 1, max);
        }
    }

    public static String guessWord(int[] counts, String[] options){
        dfs("", counts, options, 0, options[0].length());
        return word;
    }

    private static ArrayList getCountsOptions(List<ArrayList> input){
        String[] options = new String[input.size()];
        int[] counts = new int[input.size()];
        for(int index = 0; index < input.size(); index++){
            options[index] = (String) input.get(index).get(0);
            counts[index] = (int) input.get(index).get(1);
        }
        ArrayList list = new ArrayList();
        list.add(options);
        list.add(counts);
        return list;
    }

    public static void main(String[] args) {
        List<ArrayList> countsOptions = new ArrayList<>();
        ArrayList countsOption = new ArrayList();
        countsOption.add("MOXTE");
        countsOption.add(3);
        countsOptions.add(countsOption);
        countsOption = new ArrayList();
        countsOption.add("AXCDG");
        countsOption.add(0);
        countsOptions.add(countsOption);
        countsOption = new ArrayList();
        countsOption.add("MOQRT");
        countsOption.add(2);
        countsOptions.add(countsOption);
        countsOption = new ArrayList();
        countsOption.add("FOUSE");
        countsOption.add(4);
        countsOptions.add(countsOption);
        countsOption = new ArrayList();
        countsOption.add("POWER");
        countsOption.add(1);
        countsOptions.add(countsOption);

        ArrayList res =  getCountsOptions(countsOptions);

        guessWord((int[])res.get(1),(String[])res.get(0));
        System.out.println(word);

        countsOptions = new ArrayList<>();
        countsOption = new ArrayList();
        countsOption.add("MOXTE");
        countsOption.add(3);
        countsOptions.add(countsOption);
        countsOption = new ArrayList();
        countsOption.add("AXCDG");
        countsOption.add(0);
        countsOptions.add(countsOption);
        countsOption = new ArrayList();
        countsOption.add("MOQRT");
        countsOption.add(2);
        countsOptions.add(countsOption);
        countsOption = new ArrayList();
        countsOption.add("FAAAA");
        countsOption.add(1);
        countsOptions.add(countsOption);
        countsOption = new ArrayList();
        countsOption.add("POWER");
        countsOption.add(1);
        countsOptions.add(countsOption);

        res =  getCountsOptions(countsOptions);

        guessWord((int[])res.get(1),(String[])res.get(0));
        System.out.println(word);
    }
}
