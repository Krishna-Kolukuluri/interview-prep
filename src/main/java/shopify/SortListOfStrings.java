package shopify;

import java.util.*;

public class SortListOfStrings {
    public static void main(String args[]) {
        List<String> list = Arrays.asList("10", "1", "20", "11", "21", "12");
        Comparator<String> cmp = new Comparator<String>() {
        public int compare(String o1, String o2) {
          return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
        }
        };
        Collections.sort(list, cmp);
        list.forEach(x->{System.out.println(x);});
        
        
        
        List<String> listOfStrings = Arrays.asList("efb", "bcd", "ab", "ef", "sw", "ad");
        
        Collections.sort(listOfStrings, new Comparator<String>() {
          @Override
          public int compare(String u1, String u2) {
            return u1.compareTo(u2);
          }
        });
        
        listOfStrings.forEach(x->{System.out.println(x);});
      }
}
