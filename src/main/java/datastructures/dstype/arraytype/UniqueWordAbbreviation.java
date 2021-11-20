package datastructures.dstype.arraytype;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueWordAbbreviation {
    HashMap<String, HashSet<String>> abbrMap;

    public UniqueWordAbbreviation(String[] dictionary) {
        abbrMap = new HashMap<String, HashSet<String>>();
        for (String str : dictionary) {
            String abr = calculateAbbreviation(str);
            HashSet<String> tempSet = abbrMap.getOrDefault(abr, new HashSet<String>());
            tempSet.add(str);
            abbrMap.put(abr, tempSet);
        }
    }

    public String calculateAbbreviation(String str) {
        if (str.length() == 2) {
            return str;
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        sb.append(len - 2);
        sb.append(str.charAt(len - 1));
        return sb.toString();
    }

    public boolean isUnique(String word) {
        if(word == null){
            return true;
        }
        String abr = calculateAbbreviation(word);

        if (abbrMap.containsKey(abr)) {
            if(abbrMap.get(abr).size()>=2){
                return false;
            }
            if(!abbrMap.get(abr).contains(word)){
                return false;
            }
        }
        return true;
    }
}
