package datastructures.dstype.arraytype;

import java.util.*;

public class ArrayImbalance {
    public static void main(String[] args) {
        Imbalance imbalance = new Imbalance();
        List<Integer> weights = new ArrayList<Integer>(Arrays.asList(3,3,2,3));
        long imbalanceResult = getTotalImbalance(weights);
        System.out.println(imbalanceResult);
        imbalanceResult = imbalance.findImbalance(weights);
        System.out.println(imbalanceResult);
        weights = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        imbalanceResult = getTotalImbalance(weights);
        System.out.println(imbalanceResult);
        imbalanceResult = imbalance.findImbalance(weights);
        System.out.println(imbalanceResult);

    }
    //Worst performing approach
    //Brut force
    //Time complexity: O(N) * N * (N-1)/2
    //Space complexity: O(N)
    public static long  getTotalImbalance(List<Integer> weights){
        long result = 0;
        for(int step=2;step<=weights.size();step++){
            result += calculateImbalance(weights,step, 0);
        }
        return result;
    }
    public static long calculateImbalance(List<Integer> weights, int step, int start){
        int totalCombs = weights.size() - step + 1;
        long result = 0;
        while(totalCombs>0){
            List<Integer> subList = weights.subList(start, start + step);
            Collections.sort(subList);
            result  += subList.get(subList.size() - 1) - subList.get(0);
            totalCombs--;
            start++;
        }
        return result;
    }


}

class Imbalance{
    //Imbalance of an Array of Integers is SUM(max(subArrays of Array)) - SUM(min(subArrays of Array))
    //Best possible solution is to find SUM(max(subArrays of Array)) and SUM(min(subArrays of Array)) then subtract them.
    //Time Complexity O(N)
    //Space Complexity O(N)
    public int findImbalance(List<Integer> list){
        int[] nums = list.stream().mapToInt(i->i).toArray();
        int ans=0;
        for(int i=2;i<=list.size();i++){
            int[] min= minSlidingWindow(nums,i);
            int[] max= maxSlidingWindow(nums,i);
            for(int j=0;j<min.length;j++){
                ans+=max[j]-min[j];
            }

        }
        return ans;

    }
    public int[] minSlidingWindow(int[] nums, int k){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int minV =0;
        for(int i=0;i<k;i++){
            cleanMinDeque(i,dq, k,  nums);
            dq.addLast(i);
            if(nums[i]<nums[minV]){
                minV=i;
            }
        }
        int[] min = new int[nums.length-k+1];
        min[0]=nums[minV];
        int j=1;
        for(int i=k;i<nums.length;i++){
            cleanMinDeque(i,dq, k, nums);
            dq.addLast(i);
            min[j++]=nums[dq.peekFirst()];

        }
        return min;
    }
    public void cleanMinDeque(int i, Deque<Integer> dq , int k, int[] nums ){
        if(!dq.isEmpty() && dq.getFirst() ==(i-k))
            dq.removeFirst();

        while(!dq.isEmpty() && nums[i]<nums[dq.getLast()]){
            dq.removeLast();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int maxV =0;
        for(int i=0;i<k;i++){
            cleanMaxDeque(i,dq, k,  nums);
            dq.addLast(i);
            if(nums[i]>nums[maxV]){
                maxV=i;
            }
        }
        int[] max = new int[nums.length-k+1];
        max[0]=nums[maxV];
        int j=1;
        for(int i=k;i<nums.length;i++){
            cleanMaxDeque(i,dq, k, nums);
            dq.addLast(i);
            max[j++]=nums[dq.peekFirst()];

        }
        return max;
    }
    public void cleanMaxDeque(int i, Deque<Integer> dq , int k, int[] nums ){
        if(!dq.isEmpty() && dq.getFirst() ==(i-k))
            dq.removeFirst();

        while(!dq.isEmpty() && nums[i]>nums[dq.getLast()]){
            dq.removeLast();
        }
    }
}
