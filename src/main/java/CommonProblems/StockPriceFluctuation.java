package CommonProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
* https://leetcode.com/problems/stock-price-fluctuation/
* https://leetcode.com/problems/stock-price-fluctuation/discuss/1513413/JavaC%2B%2BPython-Strightforward-Solutions
*You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.
Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records
may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

Design an algorithm that:
Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
Finds the maximum price the stock has been based on the current records.
Finds the minimum price the stock has been based on the current records.
Implement the StockPrice class:

StockPrice() Initializes the object with no price records.
void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
int current() Returns the latest price of the stock.
int maximum() Returns the maximum price of the stock.
int minimum() Returns the minimum price of the stock.
*
Example 1:
Input
["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
Output
[null, null, null, 5, 10, null, 5, null, 2]
Explanation
StockPrice stockPrice = new StockPrice();
stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
                          // Timestamps are [1,2] with corresponding prices [3,5].
stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
stockPrice.minimum();     // return 2, the minimum price is 2 at timestamp 4.
*
* */
public class StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1,3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4,2);
        System.out.println(stockPrice.minimum());
    }
}

class StockPrice{
    //Map to keep track of Stock Price(Value) and TimeStamp(Key) in map
    private Map<Integer, Integer> stockStreamMap;
    //Map to keep track of price(Key) and its count(Val)
    private TreeMap<Integer, Integer> stockPriceMap;
    private int latestTimestamp = 0;

    public StockPrice(){
        stockStreamMap = new HashMap<Integer, Integer>();
        stockPriceMap = new TreeMap<>();
    }

    //Get price for latest timestamp
    public int current(){
        return stockStreamMap.get(latestTimestamp);
    }

    public int maximum(){
        return stockPriceMap.lastKey();
    }

    public int minimum(){
        return stockPriceMap.firstKey();
    }

    public void update(int timestamp, int price){
        latestTimestamp = Math.max(latestTimestamp, timestamp);
        int existingPrice = stockStreamMap.getOrDefault(timestamp, 0);
        if(existingPrice == price){
            return;
        }

        if(existingPrice != 0){
            int priceRepetitionCount = stockPriceMap.get(existingPrice) - 1;
            if(priceRepetitionCount == 0){
                stockPriceMap.remove(existingPrice);
            }else {
                stockPriceMap.replace(existingPrice, priceRepetitionCount);
            }
        }

        stockStreamMap.put(timestamp, price);
        stockPriceMap.put(price, stockPriceMap.getOrDefault(price, 0)+1);
    }
}
