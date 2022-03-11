package salesforce;

public class ArrangeCoinsinStairCase {
//O(logn)
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        long k, curr;
        while (left <= right) {
          k = left + (right - left) / 2;
          curr = k * (k + 1) / 2;

          if (curr == n) return (int)k;

          if (n < curr) {
            right = k - 1;
          } else {
            left = k + 1;
          }
        }
        return (int)right;
      }
    
    //Math formula O(1)
    
    public int arrangeCoinsMath(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
      }
}
