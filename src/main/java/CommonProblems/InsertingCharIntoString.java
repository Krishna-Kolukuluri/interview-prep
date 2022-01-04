package CommonProblems;

/*
*
Given a string, you have to insert 'a' into it, subject to the condition that the string cannot contain 3 consecutive a's.
* Return the maximum number of a's that can be inserted. For eg: dog: return 8, as you can make aadaaoaagaa.

* */
public class InsertingCharIntoString {
    public static void main(String[] args) {
        CharManipulation charManipulation = new CharManipulation();
        System.out.println(charManipulation.findMaximumNumberOfCharsCanBeInserted("god",'g',2));
        System.out.println(charManipulation.findMaximumNumberOfCharsCanBeInserted("god",'a',2));
    }
}
class CharManipulation{
    private String inputString;
    private char inputChar;
    public CharManipulation(String stringToManipulate, char charToInsert){
        inputString = stringToManipulate;
        inputChar = charToInsert;
    }
    public CharManipulation(){

    }

    public long findMaximumNumberOfCharsCanBeInserted(int consecutiveCharLimit){
        return maxNumOfCharsToInsert(consecutiveCharLimit);
    }

    public long findMaximumNumberOfCharsCanBeInserted(String stringToManipulate, char charToInsert, int consecutiveCharLimit){
        inputString = stringToManipulate;
        inputChar = charToInsert;
        return maxNumOfCharsToInsert(consecutiveCharLimit);
    }
    private long maxNumOfCharsToInsert(int consecutiveCharLimit){
        //a and A both are considered as same character.
        //Find total number of non input chars and input chars in input-string.
        // formula to calculate max num of chars is ((nonCharsCount * 2 ) + 2 - charCount)
        String lowerCaseString = inputString.toLowerCase();
        char lowerCaseChar = String.valueOf(inputChar).toLowerCase().charAt(0);
        long inputCharCount = lowerCaseString.chars().filter(ch ->  ch == lowerCaseChar).count();
        return  (lowerCaseString.length() * consecutiveCharLimit) + consecutiveCharLimit - inputCharCount;
    }
}