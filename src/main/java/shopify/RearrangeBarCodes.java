package shopify;

import java.util.PriorityQueue;

public class RearrangeBarCodes {
    //Rearrange Array elements -no two identical are side by side
    public static void main(String args[]) {
        int[] barcodes = {1,1,1,2,2,2,3,3,3,3,3,3,4,4,4,4,4,4,4};
        rearrangeBarcodes(barcodes);
        for(int i=0;i<barcodes.length;i++){
            System.out.println(barcodes[i]);
        }
    }
    
    public static int[] rearrangeBarcodes(int[] barcodes) {

        int[] frequency = new int[10001];

        for (int barcode : barcodes) {
            ++frequency[barcode];
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<> ((barcode1, barcode2) -> frequency[barcode1] - frequency[barcode2]); /// Sort frequency in descending order

        for (int barcode = 1; barcode <= 10000; barcode++) {
            if (frequency[barcode] != 0) {
                maxHeap.offer (barcode);
            }
        }

        int index = 0;

        while (!maxHeap.isEmpty ()) {
            int barcode = maxHeap.poll ();
            int freq = frequency[barcode];

            while (freq-- != 0) {
                barcodes[index] = barcode;
//                System.out.println(index+"  :  "+barcode);
                index += 2;
                if (index >= barcodes.length) {
                    index = 1;
                }
            }
        }

        return barcodes;
    }
}
