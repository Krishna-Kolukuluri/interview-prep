package CommonProblems;

import java.util.Random;

/*
*Roulette game with 50% chance of occurance of red/black. The gambler has $50 and wants to bet till he has no money left
* or till he wins $100. He will always bet red after 4 consecutive blacks and black after 4 consecutive reds. Write a
* program to simulate this and find whether he won or lost.
* */
public class RouletteGameWayfair {
    public static void main(String[] args) {
        RouletteGame game = new RouletteGame(50,4);
        System.out.println(game.isPlayerWin());
    }
}
class RouletteGame{
    private String[] colours = {"RED","BLACK"};
    private int cash;
    private int target = 0;
    private int betChangeCount;
    private int blackCount = 0;
    private int redCount = 0;
    private String black = "BLACK";
    private String red = "RED";
    public RouletteGame(int cash, int betChangeCount){
        this.cash = cash;
        this.betChangeCount = betChangeCount;
    }

    public boolean isPlayerWin(){
        Random random = new Random();
        while (cash>0 && target<100){
            int rand = random.nextInt(colours.length);
            if(colours[rand].equals(red)){
                if(blackCount == betChangeCount){
                    target = 2 * cash;
                    cash = target;
                }
                blackCount = 0;
                redCount++;
                if(redCount>betChangeCount){
                    cash = 0;
                    target = 0;
                }
            }
            else{
                if(redCount == betChangeCount){
                    target = 2 * cash;
                    cash = target;
                }
                redCount = 0;
                blackCount++;
                if(blackCount>betChangeCount){
                    cash = 0;
                    target = 0;
                }
            }
        }
        if(cash <= 0){
            return false;
        }
        if(target >= 100){
            return true;
        }
        return false;
    }
}
