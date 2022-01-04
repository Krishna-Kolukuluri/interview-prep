package CommonProblems;

import java.util.PriorityQueue;

/*
*
 Given 3 integers A, B, C, they represent the count of the letters 'a', 'b', and 'c'. Return any string that contains A number of a's,
 B number of b's, and C number of c's, subject to the condition that it cannot contain 3 consecutive a's, b's, or c's.
 For example A=1,B=2,C=3; you may return abccbc.
*
* */
public class UnOrderCharacter {
    public static void main(String[] args) {
        UnOrder unOrder = new UnOrder();
        String result = unOrder.getUnorderedString('C', 8, 'B', 24, 'A', 1);
        System.out.println(result);
    }
}
class UnOrder{
    public String getUnorderedString(char charOne, int charOneCount,
                                     char charTwo, int charTwoCount,
                                     char charThree, int charThreeCount){
        PriorityQueue<CharCountTuple> priorityQueue = new PriorityQueue<CharCountTuple>();
        CharCountTuple charCountTuple = new CharCountTuple();
        charCountTuple.count = charOneCount;
        charCountTuple.data = charOne;
        priorityQueue.offer(charCountTuple);
        charCountTuple = new CharCountTuple();
        charCountTuple.count = charTwoCount;
        charCountTuple.data = charTwo;
        priorityQueue.offer(charCountTuple);
        charCountTuple = new CharCountTuple();
        charCountTuple.count = charThreeCount;
        charCountTuple.data = charThree;
        priorityQueue.offer(charCountTuple);

        StringBuilder stringBuilder = new StringBuilder();
        CharCountTuple firstMaxTuple = new CharCountTuple(), secondMaxTuple = new CharCountTuple(), thirdMaxTuple = new CharCountTuple();
        while (!priorityQueue.isEmpty()){
            if(priorityQueue.size() == 3){
                firstMaxTuple = priorityQueue.poll();
            }else if(priorityQueue.size() == 2){
                secondMaxTuple = priorityQueue.poll();
            }else if(priorityQueue.size() == 1){
                thirdMaxTuple = priorityQueue.poll();
            }
        }
        int charCounts =(secondMaxTuple.count + thirdMaxTuple.count) * 2 + 2;
        if(charCounts < firstMaxTuple.count){
            return "Input chars counts are invalid";
        }
        priorityQueue.offer(firstMaxTuple);
        priorityQueue.offer(secondMaxTuple);
        priorityQueue.offer(thirdMaxTuple);
        int tempCharCount = 1;
        char tempChar = ' ';
        while (!priorityQueue.isEmpty()){
            firstMaxTuple = priorityQueue.poll();
            if(firstMaxTuple.data != tempChar){
                tempCharCount = 1;
                tempChar = firstMaxTuple.data;
            }else{
                tempCharCount++;
            }
            if(tempCharCount <=2){
                stringBuilder.append(firstMaxTuple.data);
                firstMaxTuple.count--;
            }else{
                tempCharCount = 1;
                tempChar = ' ';
                if(!priorityQueue.isEmpty()) {
                    secondMaxTuple = priorityQueue.poll();
                    tempChar = secondMaxTuple.data;
                    stringBuilder.append(secondMaxTuple.data);
                    secondMaxTuple.count--;
                    if (secondMaxTuple.count > 0) {
                        priorityQueue.offer(secondMaxTuple);
                    }
                }
            }
            if(firstMaxTuple.count>0){
                priorityQueue.offer(firstMaxTuple);
            }
        }
        return stringBuilder.toString();
    }

}
class CharCountTuple implements Comparable<CharCountTuple>{
    public int count;
    public char data;
    @Override
    public int compareTo(CharCountTuple o) {
        return Integer.valueOf(o.count).compareTo(this.count);
    }
}
