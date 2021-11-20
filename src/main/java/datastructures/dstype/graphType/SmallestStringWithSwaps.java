package datastructures.dstype.graphType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
Smallest String With Swaps
You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
You can swap the characters at any pair of indices in the given pairs any number of times.
Return the lexicographically smallest string that s can be changed to after using the swaps
* */
public class SmallestStringWithSwaps {
    /*
        // 1)think pair as edge
    // and pos as node
    // then we can build several connected component
    // in each component, any two pos can be reached
    // pos1->a->b->c->pos2
    // a->pos1->b->c->pos2
    // a->b->pos1->c->pos2
    // a->b->c->pos1->pos2
    // a->b->c->pos2->pos1
    // a->b->pos2->c->pos1
    // a->pos2->b->c->pos1
    // pos2->a->b->c->pos1
    // then, it means any two pos's character can be exhanged meanwhile
    // keeping other character pos unchanged.
    // this means we can freelly arrange the all the charcters within
    // same connected component
    // 2)for different connected component, they are isolated

    * */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs){
        UnionFindCls unionFindCls = new UnionFindCls(s.length());
        //Generating disjointSets for connected components/graphs.
        for(List<Integer> pair: pairs){
            unionFindCls.union(pair.get(0), pair.get(1));
        }

        //Generating all possible graphs with their respective nodes(chars)
        Map<Integer, PriorityQueue<Character>> graph = new HashMap<>();
        char[] sChar = s.toCharArray();
        for(int index=0;index<sChar.length;index++){
            int rootOfIndex = unionFindCls.findParentRoot(index);
            graph.putIfAbsent(rootOfIndex, new PriorityQueue<>());
            graph.get(rootOfIndex).offer(sChar[index]);
        }
        StringBuilder result = new StringBuilder();
        for(int index=0;index<sChar.length;index++){
            int rootOfIndex = unionFindCls.findParentRoot(index);
            result.append(graph.get(rootOfIndex).poll());
        }
        return result.toString();
    }


    class UnionFindCls{
        int[] parents;
        int[] ranks;
        public UnionFindCls(int size){
            parents = new int[size];
            ranks = new int[size];
            for(int position=0;position<size;position++){
                parents[position] = position;
                ranks[position] = 1;
            }
        }
        public int findParentRoot(int index){
            if(index == parents[index]){
                return index;
            }
            return parents[index] = findParentRoot(parents[index]);
        }
        public void union(int indexA, int indexB){
            int rootOfA = findParentRoot(indexA);
            int rootOfB = findParentRoot(indexB);
            if(rootOfA != rootOfB){
                if(ranks[rootOfA] > ranks[rootOfB]){
                    parents[rootOfB] = rootOfA;
                }else if(ranks[rootOfA] < ranks[rootOfB]){
                    parents[rootOfA] = rootOfB;
                }else {
                    parents[rootOfB] = rootOfA;
                    ranks[rootOfA] += 1;
                }
            }
        }
    }
}
