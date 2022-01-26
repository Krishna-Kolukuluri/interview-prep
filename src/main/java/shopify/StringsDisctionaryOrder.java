package shopify;

public class StringsDisctionaryOrder {

    public static void main(String args[]) {
        String[] words = {"hello","leetcode"};
        String  order = "hlabcdefgijkmnopqrstuvwxyz";
       System.out.println(isAlienSorted(words,order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] alienAlphabet = new int[26];
        mapWithAlienAlphabetInOrder(alienAlphabet, order);
        for (int i = 0;i< words.length-1;i++) {
            String curr = words[i];
            String next = words[i+1];
            int minLen = Math.min(curr.length(), next.length());
            if (minLen != curr.length() && curr.startsWith(next)) {
                return false;
            }
            for (int start = 0; start < minLen; start ++) {
                if (alienAlphabet[curr.charAt(start)-'a'] > alienAlphabet[next.charAt(start)-'a']) {
                    return false;
                }
                if (alienAlphabet[curr.charAt(start)-'a'] < alienAlphabet[next.charAt(start)-'a']) {
                    break;
                }
            }
        }
        return true;
    }

    public static void mapWithAlienAlphabetInOrder(int[] alienAlphabet, String order) {
        int seq = 0;
        for (char ch: order.toCharArray()) {
            alienAlphabet[ch-'a'] = seq++; 
        }
    }
}
