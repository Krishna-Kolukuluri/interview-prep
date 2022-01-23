package CommonProblems;

import java.math.BigInteger;
import java.util.Arrays;

/*
Write a program to find sum of all prime numbers between 1 to n.
* */
public class SumOfPrimeNums {
    public static void main(String[] args) {
        int n = 1000000000;
        System.out.println(primsSum(n));
    }

    public static BigInteger primsSum(int n){
        // Array to store prime numbers
        boolean prime[]=new boolean[n + 1];

        // Create a boolean array "prime[0..n]"
        // and initialize all entries it as true.
        // A value in prime[i] will finally be
        // false if i is Not a prime, else true.
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {

            // If prime[p] is not changed, then
            // it is a prime
            if (prime[p] == true) {

                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Return sum of primes generated through
        // Sieve.
        BigInteger sum = new BigInteger("0");
        int primeCount = 0;
        for (int i = 2; i <= n; i++){
            if (prime[i]){
                //System.out.println(i);
                primeCount++;
                BigInteger temp = BigInteger.valueOf(i);
                sum = sum.add(temp);
            }
        }
        System.out.println(primeCount);

        return sum;
    }
}
