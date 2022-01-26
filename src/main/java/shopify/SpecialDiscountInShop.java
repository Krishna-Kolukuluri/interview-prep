package shopify;

import java.util.ArrayDeque;

public class SpecialDiscountInShop {
    
    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        int[] finalPrice = finalPrices(prices);
        for(int i=0;i<finalPrice.length;i++){
            System.out.println(finalPrice[i]);
        }
        //Wrong
        int[] finalPrice2 = finalPrices_oofn(prices);
        for(int i=0;i<finalPrice2.length;i++){
            System.out.println(finalPrice2[i]);
        }
    }
    public static int[] finalPrices(int[] prices) {
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] <= prices[i]){
                    prices[i] = prices[i]-prices[j];
                    break;
                }
            }
        }
        return prices;
    }
    
    
//    Input: prices = [8,4,6,2,3]
//            Output: [4,2,4,2,3]
//            Explanation: 
//            For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4. 
//            For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2. 
//            For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4. 
//            For items 3 and 4 you will not receive any discount at all.
    
//    Input: prices = [1,2,3,4,5]
//            Output: [1,2,3,4,5]
//            Explanation: In this case, for all items, you will not receive any discount at all.
    
//    This problem is pretty simple if you know that you are actually finding next smaller element for a particular element, i.e. , 
//    we are finding the previous smaller element for an element from the right. Thus, we use a stack to store the elements until the peek or 
//    top element in the stack is smaller than the current element, because we need the smaller and previous one, and after each iteration, we push the current element in the stack.
//    Note that in the worst case, the time complexity will be O(2n)=O(n)
//    These are typical stack problems, so solve these to get more intuition.
    
    public static int[] finalPrices_oofn(int[] prices)
    {
        int n= prices.length;
        int[] arr=new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(prices[n-1]);
        arr[n-1]=prices[n-1];
        for (int i = n-2; i >= 0;i--)
        {
            while (!stack.isEmpty() && stack.peek()>prices[i])
                stack.pop();
            if (stack.isEmpty())
                arr[i]=prices[i];
            else
                arr[i]=prices[i]-stack.peek();
            stack.push(prices[i]);
        }
        return arr;
    }
}
