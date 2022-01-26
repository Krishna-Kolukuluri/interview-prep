package amazon.DynamicProgramming;

import java.util.Arrays;

public class ProfitInStocks {
    
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        System.out.println(minprice);
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
    public static void main(String args[]){
        int prices[] = { 12, 11, 13, 5, 6, 7,3, 6 };
        Arrays.sort(prices);
        System.out.println(maxProfit(prices));
    }

}
