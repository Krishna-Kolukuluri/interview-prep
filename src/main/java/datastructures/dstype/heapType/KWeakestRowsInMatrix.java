package datastructures.dstype.heapType;

import java.util.Collections;
import java.util.PriorityQueue;

/*
*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers
are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
*
* */
public class KWeakestRowsInMatrix {
    public static void main(String[] args) {

    }

    public static int[] kWeakestRows(int[][] mat, int k){
        PriorityQueue<RowOrder> maxHeap = new PriorityQueue<RowOrder>((A,B) -> {
            if(A.getNumOfSoldiers() == B.getNumOfSoldiers()) {
                return B.getRowIndex() - A.getRowIndex();
            }
            else {
                return B.getNumOfSoldiers() - A.getNumOfSoldiers();
            }
        });
        int numOfRows = mat.length;
        for(int index=0; index< numOfRows; index++){
            int numOfSoldiers = getNumOfSoldiers(mat[index]);
            RowOrder rowOrder = new RowOrder(index, numOfSoldiers);
            maxHeap.add(rowOrder);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[] weakRowIndexes = new int[k];
        for(int index=k-1;index>=0;index--){
            weakRowIndexes[index] = maxHeap.poll().getRowIndex();
        }
        return weakRowIndexes;
    }

    public static int getNumOfSoldiers(int[] row){
        int left  = 0;
        int right = row.length;
        while (left < right){
            int pivot = left + ((right - left)>>1);
            if(row[pivot] == 1){
                left = pivot + 1;
            }
            else {
                right = pivot;
            }
        }
        return left;
    }
}

class RowOrder{
    int rowIndex;
    int numOfSoldiers;
    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getNumOfSoldiers() {
        return numOfSoldiers;
    }

    public void setNumOfSoldiers(int numOfSoldiers) {
        this.numOfSoldiers = numOfSoldiers;
    }


    public RowOrder(int rowIndex, int numOfSoldiers){
        this.numOfSoldiers = numOfSoldiers;
        this.rowIndex = rowIndex;
    }
}
