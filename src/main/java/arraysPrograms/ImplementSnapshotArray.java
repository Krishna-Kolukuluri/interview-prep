package arraysPrograms;

import java.util.HashMap;

/*
* https://leetcode.com/problems/snapshot-array/
* Implement a SnapshotArray that supports the following interface:
SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
*
* Example 1:
Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation:
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
* */
public class ImplementSnapshotArray {
    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(4);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.get(3,1);
        snapshotArray.set(2,4);
        snapshotArray.snap();
        snapshotArray.set(1,4);
    }
}
class SnapshotArray{
    private HashMap<Integer, Integer> map;
    private HashMap<Integer, HashMap<Integer, Integer>> snapMap;
    private int snapCount = 0;

    public SnapshotArray(int length){
        map = new HashMap<>();
        snapMap = new HashMap<>();
    }

    public void set(int index, int val){
        map.put(index, val);
    }

    public int get(int index, int snap_id){
        if(snapMap.containsKey(snap_id)){
            HashMap<Integer, Integer> temMap = snapMap.get(snap_id);
            if(temMap.containsKey(index)){
                return temMap.get(index);
            }
        }
        return 0;
    }

    public int snap(){
        HashMap<Integer, Integer> cloned = (HashMap<Integer, Integer>) map.clone();
        snapMap.put(snapCount, cloned);
        return snapCount++;
    }
}
