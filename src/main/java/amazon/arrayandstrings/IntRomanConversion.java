package amazon.arrayandstrings;

import java.util.HashMap;
import java.util.Map;

public class IntRomanConversion {
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public static void main(String args[]) {
//        System.out.println(intToRoman(45));
        System.out.println(romanToInt("MCMXCIV"));
    }

    static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    static int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String doubleSymbol = s.substring(i, i + 2);
                System.out.println(doubleSymbol);
                // Check if this is the length-2 symbol case.
                if (values.containsKey(doubleSymbol)) {
                    sum += values.get(doubleSymbol);
                    System.out.println(sum);
                    i += 2;
                    continue;
                }
            }
            // Otherwise, it must be the length-1 symbol case.
            String singleSymbol = s.substring(i, i + 1);
            sum += values.get(singleSymbol);
            i += 1;
        }
        return sum;
    }

}
