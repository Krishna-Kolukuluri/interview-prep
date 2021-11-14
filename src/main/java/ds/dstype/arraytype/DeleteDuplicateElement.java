package ds.dstype.arraytype;

public class DeleteDuplicateElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};

        int[] numSquares = removeDuplicates(nums);
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }
    }

    static int[] removeDuplicates(int[] nums){
        int count = 0;

        for(int index=0; index<nums.length;index++){
            if(index < nums.length -1 && nums[index] == nums[index + 1]){
                continue;
            }
            nums[count++] = nums[index];
        }

        return nums;
    }

    public int removeDuplicatesInplace(int[] nums) {

        // Check for edge cases.
        if (nums == null) {
            return 0;
        }

        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;
        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element we're reading is *different* to the previous
            // element...
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums[writePointer] = nums[readPointer];
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }

        // This turns out to be the correct length value.
        return writePointer;
    }
}
