package roboProgram;

import java.awt.Robot;
import java.util.Random;

public class SampleRobo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
            Random randomGenerator=new Random();
            Robot robot=new Robot();
            while(true){
                int xCoord=randomGenerator.nextInt(1000);
                int yCoord=randomGenerator.nextInt(1000);
                Thread.sleep(100000);
                robot.mouseMove(xCoord, yCoord);
            }
            
        }catch(Exception e){
            
        }
    }

}
