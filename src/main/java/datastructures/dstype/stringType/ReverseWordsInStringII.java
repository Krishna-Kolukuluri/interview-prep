package datastructures.dstype.stringType;

public class ReverseWordsInStringII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest")); //s'teL ekat edoCteeL tsetnoc
    }
    public static String reverseWords(String s){
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int index=0;index<=words.length-1;index++){
            char[] chars = words[index].toCharArray();
            int startIndex = 0;
            int lastIndex = chars.length -1;
            while (startIndex<lastIndex){
                char cTemp = chars[startIndex];
                chars[startIndex] = chars[lastIndex];
                chars[lastIndex] = cTemp;
                startIndex++;
                lastIndex--;
            }
            String word = String.valueOf(chars);
            sb.append(" ").append(word);
        }
        return sb.toString().trim();
    }
}
