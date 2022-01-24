package datastructures.dstype.trietype;

import java.util.*;
/*
Auto-complete feature using Trie
Implement Autocomplete on phone keyboard.
*
We are given a Trie with a set of strings stored in it. Now the user types in a prefix of his search query, we need to
give him all recommendations to auto-complete his query based on the strings stored in the Trie. We assume that the Trie stores past searches by the users.
For example if the Trie store {“abc”, “abcd”, “aa”, “abbbaba”} and the User types in “ab” then he must be shown {“abc”, “abcd”, “abbbaba”}.
* */
public class TrieAutoComplete{
    public static void main(String[] args) {
        List<String> words = new ArrayList<> (Arrays.asList("hello", "dog", "hell", "cat", "a", "hel","help","helps","helping"));
        Trie trie = new Trie(words);
        System.out.println(trie.suggest("hell"));
    }
}
class Trie {
    TrieNode root;
    public Trie(List<String> words){
        root = new TrieNode();
        for(String word: words){
            root.insert(word);
        }
    }
    public boolean find(String prefix, boolean exact){
        TrieNode lastNode = root;
        for(char c: prefix.toCharArray()){
            lastNode = lastNode.children.get(c);
            if(lastNode == null){
                return false;
            }
        }
        return !exact || lastNode.isWord;
    }
    public boolean find(String prefix){
        return find(prefix, false);
    }
    public void  suggestHelper(TrieNode root, List<String> list, StringBuffer curr){
        if(root.isWord){
            list.add(curr.toString());
        }
        if(root.children == null || root.children.isEmpty()){
            return;
        }
        for(TrieNode child : root.children.values()){
            suggestHelper(child, list, curr.append(child.nodeChar));
            curr.setLength(curr.length() - 1);
        }
    }
    public List<String> suggest(String prefix){
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer curr = new StringBuffer();
        for(char c: prefix.toCharArray()){
            lastNode = lastNode.children.get(c);
            if(lastNode == null){
                return  list;
            }
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }
}
class TrieNode{
    Map<Character, TrieNode> children;
    char nodeChar;
    boolean isWord;
    boolean isLeaf;
    int wordCount = 0;
    int prefixCount = 0;
    public TrieNode(char c){
        this.nodeChar = c;
        children = new HashMap<>();
    }
    public TrieNode(){
        children = new HashMap<>();
    }
    public void insert(String word){
        if(word == null || word.isEmpty()){
            return;
        }
        char firstChar = word.charAt(0);
        TrieNode child = children.get(firstChar);
        if(child == null){
            child = new TrieNode(firstChar);
            child.prefixCount++;
            children.put(firstChar, child);
        }
        if(word.length() > 1){
            child.insert(word.substring(1));
        }else{
            child.isWord = true;
            child.isLeaf = true;
            child.wordCount++;
        }
    }
}