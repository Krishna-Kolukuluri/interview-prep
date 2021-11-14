package ds.dstype.arraytype;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] numSquares = sortedSquaresWorstSolution(nums);
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }

        nums = new int[]{-7,-3,2,3,11};
        numSquares = sortedSquaresWorstSolution(nums);
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }
    }

    static int[] sortedSquaresWorstSolution(int[] nums) {
        int inputCapacity = nums.length;
        int[] results = new int[inputCapacity];
        int index = 0;
        int maxSqrNumber = 0;

        for (int num : nums) {
            int numSqr = num * num;

            if (index == 0) {
                results[index] = numSqr;
                maxSqrNumber = numSqr;
            }

            if(numSqr >= maxSqrNumber){
                results[index] = numSqr;
                maxSqrNumber = numSqr;
            }
            else {
                maxSqrNumber = results[index - 1];
                results[index] = maxSqrNumber;
                results[index - 1] = numSqr;
                int rIndex = index;
                if(index > 0) {
                    while (rIndex >= 1) {
                        int tempOneNum = results[rIndex];
                        int tempTwoNum = results[rIndex - 1];
                        results[rIndex] = Math.max(tempTwoNum, tempOneNum);
                        results[rIndex - 1] = Math.min(tempTwoNum, tempOneNum);
                        rIndex--;
                    }
                }
            }
            index++;
        }
        return results;
    }

    static int[] sortedSquaresBestSolution(int[] nums) {
        int inputCapacity = nums.length;
        int[] results = new int[inputCapacity];

        int startIndex = 0;
        while (startIndex < inputCapacity-1 && nums[startIndex] < 0){
            startIndex++;
        }
        int outputIndex = 0;
        int leftIndex = startIndex - 1;
        int rightIndex = startIndex;
        while (leftIndex >=0 && rightIndex< inputCapacity){
            int leftNumSquare = nums[leftIndex] * nums[leftIndex];
            int rightNumSquare = nums[rightIndex] * nums[rightIndex];
            results[outputIndex++] = Math.min(leftNumSquare , rightNumSquare);
            if(leftNumSquare > rightNumSquare){
                rightIndex++;
            }
            else {
                leftIndex--;
            }
        }
        while(leftIndex >= 0){
            results[outputIndex++] = nums[leftIndex] * nums[leftIndex];
            leftIndex--;
        }
        while (rightIndex<nums.length){
            results[outputIndex++] = nums[rightIndex] * nums[rightIndex];
            rightIndex++;
        }

        return results;
    }
}
