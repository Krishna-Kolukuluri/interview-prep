package datastructures.dstype.graphType;

import java.util.Arrays;
/*
The Earliest Moment When Everyone Become Friends
There are n people in a social group labeled from 0 to n - 1. You are given an array logs where logs[i] = [timestampi, xi, yi]
indicates that xi and yi will be friends at the time timestampi.
Friendship is symmetric. That means if a is friends with b, then b is friends with a. Also,
person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.
Return the earliest time for which every person became acquainted with every other person. If there is no such earliest time, return -1.
* */
public class EveryoneBecomeFriends {
    class UnionFindCls{
        int[] parents;
        int[] ranks;
        int count;
        public UnionFindCls(int size){
            parents = new int[size];
            ranks = new int[size];
            count = size;
            for(int node=0;node<size;node++){
                parents[node] = node;
                ranks[node] = 1;
            }
        }
        public int findParent(int node){
            if(node == parents[node]){
                return node;
            }
            return parents[node] = findParent(parents[node]);
        }
        public void union(int nodeA,int nodeB){
            int parentOfA = findParent(nodeA);
            int parentOfB = findParent(nodeB);
            if(parentOfA != parentOfB){
                if(ranks[parentOfA] > ranks[parentOfB]){
                    parents[parentOfB] = parentOfA;
                }else if(ranks[parentOfA] < ranks[parentOfB]){
                    parents[parentOfA] = parentOfB;
                }else{
                    parents[parentOfB] = parentOfA;
                    ranks[parentOfA] += 1;
                }
                count--;
            }
        }

        public int getCount(){
            return count;
        }
    }
    public int earliestAcq(int[][] logs, int n){
        UnionFindCls unionFindCls = new UnionFindCls(n);
        //Sort input logs to get correct sequence of friendships and/or acquaintance
        Arrays.sort(logs, (A,B) -> (A[0] - B[0]));
        for(int[] log:logs){
            unionFindCls.union(log[1], log[2]);
            if(unionFindCls.count == 1){
                return log[0];
            }
        }
        return -1;
    }
}
