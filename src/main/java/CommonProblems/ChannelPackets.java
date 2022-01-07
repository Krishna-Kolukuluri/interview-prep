package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
*
You have n packets of some size, n[i] that need to be transferred optimally over m channels.
Rules:

Every channel must transfer at least one packet.
The optimal solution is one where quality of transfer is highest
Quality is defined as the sum of medians of packets transferred over each channel
Median is defined as the middle element in a non-decreasing array of elements. If even, it is the average of the middle two elements.
Return the maximum possible quality of transfer. if float, take the next highest integer.

Eg 1. n= 3, packets=[2,6,3], m=2
Send packet 6 via 1st channel. Median = 6
Send packets 2,3 via 2nd channel. Median = (2+3)/2=2.5
6+2.5 = 8.5 ~ 9
Output: 9

Eg 2, n= 3, packets=[2,6,3], m=3
Send each packet in a different channel. Sum of Medians = 2+3+6 = 11

Eg 3, n=1, packets=[4], m=1
Send the packet in a channel. Sum of Medians = 4 = 4

Note:
1<=n<=10^5
1<=packets[i]<=10^9
1<=m<=n
* */
public class ChannelPackets {
    public static void main(String[] args) {
        List<Integer> packets = Arrays.asList(1,2,3,4,5);
        System.out.println(maximumQuality(packets,2));
    }

    private static long maximumQuality(List<Integer> packets, int channels){
        Collections.sort(packets);
        Collections.reverse(packets);
        List<Double> medians = new ArrayList<>();
        Integer index = 1;
        while(index<=channels -1){
            medians.add(Double.valueOf(packets.get(index-1)));
            index++;
        }
        List<Integer> subList = packets.subList(index-1, packets.size());
        Integer subListLength = subList.size();
        Integer midElm = subListLength/2; ;
        if(subListLength%2 == 0){
            Double median = (subList.get(midElm)+ subList.get(midElm-1))/2.0;
            medians.add(median);
        }else{
            medians.add(Double.valueOf(subList.get(midElm)));
        }
        Double sumOfQualities = Double.valueOf(0);
        for(Double quality: medians){
            sumOfQualities += quality;
        }
        return Math.round(sumOfQualities);
    }
}
/*
Complexity: O(nlogn+m)
* */