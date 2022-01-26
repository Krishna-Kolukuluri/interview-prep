package shopify;

import java.util.*;

public class ShoppingOffers {

    public static void main(String[] args) {
        List < Integer > price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List < Integer > needs=new ArrayList<>();
        needs.add(3);
        needs.add(2);
        List < List < Integer >> special=new ArrayList<>();
        List < Integer > special1=new ArrayList<>();
        special1.add(3);
        special1.add(0);
        special1.add(5);
        special.add(special1);
        List < Integer > special2=new ArrayList<>();
        special2.add(1);
        special2.add(2);
        special2.add(10);
        special.add(special2);
        System.out.println(shoppingOffers(price,special,needs));
    }
    
    
    //    Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
    //            Output: 14
    //            Explanation: There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
    //            In special offer 1, you can pay $5 for 3A and 0B
    //            In special offer 2, you can pay $10 for 1A and 2B. 
    //            You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.

    public static int shoppingOffers(List < Integer > price, List < List < Integer >> special, List < Integer > needs) {
        Map < List < Integer > , Integer > map = new HashMap();
        return shopping(price, special, needs, map);
    }
    public static int shopping(List < Integer > price, List < List < Integer >> special, List < Integer > needs, Map < List < Integer > , Integer > map) {
        if (map.containsKey(needs))
            return map.get(needs);
        int j = 0, res = dot(needs, price);
        for (List < Integer > s: special) {
            ArrayList < Integer > clone = new ArrayList < > (needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                res = Math.min(res, s.get(j) + shopping(price, special, clone, map));
        }
        map.put(needs, res);
        return res;
    }
    public static int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

}
