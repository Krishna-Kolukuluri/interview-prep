package recursion;

public class StringReverse {
    public static void main(String[] args) {
        String originalString = "Krishna_Kolukuluri";
        printReverse(originalString.toCharArray(), 0);
    }

    private static void printReverse(char[] charArray, int index){
        if(index>= charArray.length || charArray == null){
            return;
        }
        printReverse(charArray, index + 1);
        System.out.println(charArray[index]);
    }

    private static char[] reverseStringInplace(char[] chars){
        int startIndex = 0;
        int endIndex = chars.length - 1;
        while (startIndex < endIndex){
            char temp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return chars;
    }
}
