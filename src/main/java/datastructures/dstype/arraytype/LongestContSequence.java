package datastructures.dstype.arraytype;

import java.util.ArrayList;
import java.util.List;

public class LongestContSequence {
    public static void main(String[] args) {
        String[] user0 = new String[] {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = new String[] {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = new String[] {"a", "/one", "/two"};
        String[] user3 = new String[] {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = new String[] {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = new String[] {"a"};
        String[] user6 = new String[] {"/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"};

        List<List<String>> result = longestCommonSequenceOfStrings(user0, user1);
        System.out.println(result);

    }
    public static List<List<String>> longestCommonSequenceOfStrings(String[] str1, String[] str2){
        if(str1 == null || str2 == null){
            return new ArrayList<>();
        }
        if(str1.length == 0 || str2.length == 0){
            return new ArrayList<>();
        }
        int[][] numOfCommonCounts = new int[str1.length+1][str2.length+1];
        int maxSequence = 0;
        for(int fIdx=1;fIdx<=str1.length;fIdx++){
            for(int sIdx=1;sIdx<=str2.length;sIdx++){
                if(str1[fIdx-1].equals(str2[sIdx-1])){
                    numOfCommonCounts[fIdx][sIdx] = numOfCommonCounts[fIdx -1][sIdx - 1] + 1;
                    maxSequence = Math.max(maxSequence, numOfCommonCounts[fIdx][sIdx]);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(int fIdx=numOfCommonCounts.length-1;fIdx>=0;fIdx--){
            for(int sIdx=numOfCommonCounts[0].length -1;sIdx>=0;sIdx--){
                if(numOfCommonCounts[fIdx][sIdx] == maxSequence){
                    List<String> listOne = new ArrayList<>();
                    while (numOfCommonCounts[fIdx][sIdx] >=1 && fIdx>=0 && sIdx>=0){
                        listOne.add(str1[fIdx-1]);
                        numOfCommonCounts[fIdx][sIdx] = 0;
                        sIdx--;
                        fIdx--;
                    }
                    result.add(listOne);
                }
            }
        }
        return result;
    }
}
