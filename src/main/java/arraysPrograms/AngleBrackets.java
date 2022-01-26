package arraysPrograms;

public class AngleBrackets {
    
    public static void main(String[] args) {
        String angles = "test";
        String  result = BalanceAnglesBrackets("<<><<><");
        System.out.println(result);
    }

    public static String BalanceAnglesBrackets(String angles){
        int openCount = 0;
        int additionalLeadingOpenTags = 0;
        for (char c : angles.toCharArray()) {
            if (c == '>') {
                if (openCount == 0) {
                    additionalLeadingOpenTags++;
                } else {
                    openCount--;
                }
            } else {
                openCount++;
            }
        }
        String result = angles;
        for (int index = 0; index < additionalLeadingOpenTags; index++) {
            result = '<' + result;
        }
        for (int index = 0; index < openCount; index++) {
            result = result + '>';
        }
        return result;
    }
}