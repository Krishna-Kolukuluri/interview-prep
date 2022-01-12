package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
The problem is to write a function that takes a collection of blocks and a target word and
returns true or false depending on whether or not you can spell the target word with the collection of blocks.
n = sizeof string
m = number of blocks
complexity shall be O(n*m)


* */
public class BabyBlocks {
    public static void main(String[] args) {
        BabyBlockExample babyBlockExample = new BabyBlockExample();
        List<List<Character>> blocks = new ArrayList<>();
        List<Character> block = new ArrayList<>(Arrays.asList('A','B','C','D','E','F'));
        blocks.add(block);
        block = new ArrayList<>(Arrays.asList('A','B','Y','D','E','F'));
        blocks.add(block);
        block = new ArrayList<>(Arrays.asList('A','B','Y','D','E','F'));
        blocks.add(block);
        block = new ArrayList<>(Arrays.asList('A','B','Y','D','E','F'));
        blocks.add(block);
        block = new ArrayList<>(Arrays.asList('O','B','Y','D','E','F'));
        blocks.add(block);
        System.out.println(babyBlockExample.canBuildString(blocks, "KRISHNA"));
    }
}
class BabyBlockExample{
    public boolean canBuildString(List<List<Character>> blocks, String targetString){
        HashMap<Character, List<Integer>> charMap = new HashMap<>();
        List<Integer> blockedIndexes = new ArrayList<>();
        for(int idx=0; idx<blocks.size(); idx++){
            blockedIndexes.add(idx, 0);
        }
        for(int idx=0; idx<blocks.size();idx++){
            List<Character> block = blocks.get(idx);
            for(int i=0; i<block.size();i++){
                if(charMap.containsKey(block.get(i))){
                    charMap.get(block.get(i)).add(idx);
                }else{
                    List<Integer> val = new ArrayList<>();
                    val.add(idx);
                    charMap.put(block.get(i),val);
                }
            }
        }
        return canBuild(0, targetString, charMap, blockedIndexes);
    }

    private boolean canBuild(int index, String targetString, HashMap<Character, List<Integer>> map, List<Integer> blocked){
        if(index == targetString.length()){
            return true;
        }
        if(!map.containsKey(targetString.charAt(index))){
            return false;
        }
        List<Integer> blocks = map.get(targetString.charAt(index));
        for(int idx=0;idx<blocks.size(); idx++){
            if(blocked.get(blocks.get(idx)) == 1){
                continue;
            }
            blocked.set(blocks.get(idx), 1);
            if(canBuild(index+1, targetString, map, blocked)){
                return true;
            }
            blocked.set(blocks.get(idx), 0);
        }
        return false;
    }
}
