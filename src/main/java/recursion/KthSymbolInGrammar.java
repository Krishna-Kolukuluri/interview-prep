package recursion;

import java.util.ArrayList;

public class KthSymbolInGrammar {
    public static void main(String[] args){
        System.out.println(kThGrammar(3,2));
    }

    public static ArrayList<Integer> nThRow(ArrayList<Integer> nMinusOneRow, int n){
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (Integer val:nMinusOneRow) {
            if(val == 0){
                row.add(0);
                row.add(1);
            }else if(val == 1){
                row.add(1);
                row.add(0);
            }
        }
        return row;
    }

    public static int kThGrammarResult(ArrayList<Integer> nThRow, int k){
        return  (int)nThRow.toArray()[k];
    }

    public static int kThGrammar(int n, int k){
        ArrayList<Integer> seedRow = new ArrayList<>();
        seedRow.add(0);
        while(n > 0){
            n--;
            seedRow = nThRow(seedRow,n);
        }
       return  kThGrammarResult(seedRow, k-1);
    }

    //Best performance can be improved with memoization
    public static int kThGrammarRec(int n, int k){
        if(n == 1){
            return 0;
        }
        if(k%2 == 0) {
            if (kThGrammarRec(n - 1, k / 2) == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        else {
            if(kThGrammarRec(n-1,(k+1)/2) == 0 ){
                return 0;
            }
            else {
                return 1;
            }
        }
    }


    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) & 1;
    }

}
