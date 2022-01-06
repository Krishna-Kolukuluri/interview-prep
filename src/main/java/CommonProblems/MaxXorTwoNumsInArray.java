package CommonProblems;

import java.util.*;

/*
*
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
*
* */
public class MaxXorTwoNumsInArray {
    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(findMaxXOR(nums));
    }

    //Both List and PriorityQueue implementations are not accepted as TimeLimit getting exceeded.
    //Required O(N) Time Complexity but below implementation it is O(N^2)
    public static int findMaxXOR(int[] nums){
        List<Integer> results = new ArrayList<>();
        PriorityQueue<Integer> res = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++){
            for(int j = i; j<nums.length; j++){
                //results.add(nums[i] ^ nums[j]);
                res.offer(nums[i] ^ nums[j]);
            }
        }
        //Collections.sort(results, Collections.reverseOrder());
        return res.peek();
    }


    /*
    *
    Complexity Analysis:
        Time complexity : O(N)
        Space complexity : O(1)
        Detailed explanation --> https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/
    * */
    public int findMaximumXOR(int[] nums) {
        // Compute length L of max number in a binary representation
        int maxNum = nums[0];
        for(int num : nums) maxNum = Math.max(maxNum, num);
        int L = (Integer.toBinaryString(maxNum)).length();

        // zero left-padding to ensure L bits for each number
        int n = nums.length, bitmask = 1 << L;
        String [] strNums = new String[n];
        for(int i = 0; i < n; ++i) {
            strNums[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
        }

        TrieNode trie = new TrieNode();
        int maxXor = 0;
        for (String num : strNums) {
            TrieNode node = trie, xorNode = trie;
            int currXor = 0;
            for (Character bit : num.toCharArray()) {
                // insert new number in trie
                if (node.children.containsKey(bit)) {
                    node = node.children.get(bit);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(bit, newNode);
                    node = newNode;
                }

                // compute max xor of that new number
                // with all previously inserted
                Character toggledBit = bit == '1' ? '0' : '1';
                if (xorNode.children.containsKey(toggledBit)) {
                    currXor = (currXor << 1) | 1;
                    xorNode = xorNode.children.get(toggledBit);
                } else {
                    currXor = currXor << 1;
                    xorNode = xorNode.children.get(bit);
                }
            }
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode() {}
}
