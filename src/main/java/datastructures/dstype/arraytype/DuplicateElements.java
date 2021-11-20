package datastructures.dstype.arraytype;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,2,3,0,4,5,0};
        int[] numSquares = duplicateElementIfEquals(nums, 0);
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }

        nums = new int[]{0,0,0,0,0,0,0};
        numSquares = duplicateElementIfEquals(nums, 0);
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }
    }

    static int[] duplicateElementIfEquals(int[] nums, int elementToDuplicate){
        int arrayCapacity = nums.length;
        for(int index = 0; index< arrayCapacity; index++){
            if(nums[index] == elementToDuplicate){
                for(int tempIndex = arrayCapacity-2; tempIndex>= index; tempIndex--){
                    nums[tempIndex + 1] = nums[tempIndex];
                }
                if(index+1 <arrayCapacity){
                    nums[index + 1] = elementToDuplicate;
                }
                index++;
            }
        }
        return nums;
    }

    static int[] duplicateElementIfEqualsBestSolution(int[] nums, int elementToDuplicate){
        int numPossibleDupes = 0;
        int capacity = nums.length - 1;
        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for(int index = 0; index <= capacity - numPossibleDupes; index++){
            if(nums[index] == 0){
                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if(index == capacity - numPossibleDupes){
                    nums[capacity] = 0;
                    capacity--;;
                    break;
                }
                numPossibleDupes++;
            }
        }
        // Start backwards from the last element which would be part of new array.
        int lastIndex = capacity - numPossibleDupes;
        // Copy zero twice, and non zero once.
        for(int index = lastIndex;index>=0;lastIndex--){
            if(nums[index] == 0){
                nums[index + numPossibleDupes] = 0;
                numPossibleDupes--;
                nums[index + numPossibleDupes] = 0;
            }
            else {
                nums[index + numPossibleDupes] = nums[numPossibleDupes];
            }
        }
        return nums;
    }
}
