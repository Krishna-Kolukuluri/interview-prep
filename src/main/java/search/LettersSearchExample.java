package search;
/*
Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest
character in the array that is larger than target.

Note that the letters wrap around.
For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
* */
public class LettersSearchExample {
    public static void main(String[] args) {
        char[] letters = new char[]{'c','f', 'j'};
        char result = nextGreatestLetter(letters, 'z');
        System.out.println(result);

    }

    public static char nextGreatestLetter(char[] letters, char target){
        int left = 0;
        int right = letters.length;
        while (left < right){
            int pivot = left + ((right - left)>>1);
            if(letters[pivot] <= target){
                left = pivot + 1;
            }else{
                right = pivot;
            }
        }
        return letters[left % letters.length];
    }

}
