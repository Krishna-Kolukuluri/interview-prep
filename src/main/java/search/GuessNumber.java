package search;
/*
We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
You call a pre-defined API int guess(int num), which returns 3 possible results:
-1: The number I picked is lower than your guess (i.e. pick < num).
1: The number I picked is higher than your guess (i.e. pick > num).
0: The number I picked is equal to your guess (i.e. pick == num).
Return the number that I picked.
* */
public class GuessNumber {
    static int pickedNum = 0;
    public static void main(String[] args) {
        pickedNum = 10;
        int result = findGuessNumber(10);
        System.out.println(result);

    }
    public static int findGuessNumber(int n){
        int left = 1;
        int right = n;
        int middle  = 0;
        while (left<=right){
            middle = left + (right -left)/2;
            int guessNumStatus = guess(middle);
            if(guessNumStatus == 0){
                return middle;
            }else if(guessNumStatus == -1){
                right = middle - 1;
            }
            else if(guessNumStatus == 1){
                left = middle + 1;
            }
        }
        return right;
    }

    public static int guess(int guess){
        if(guess > pickedNum){
            return -1;
        }
        else if(guess < pickedNum){
            return 1;
        }
        else{
            return 0;
        }
    }
}
/*
Complexity Analysis:
Time complexity : O(logN).
Let's compute time complexity with the help of master theorem.
The equation represents dividing the problem up into aa subproblems of size time. Here at step there is only one
subproblem a = 1, its size is a half of the initial problem b = 2, and all this happens in a constant time d = 0.
That means that  and hence we're dealing with case 2 that results in O(logN) time complexity.

Space complexity : O(1) since it's a constant space solution.
* */
