package shopify;

import java.util.HashMap;
import java.util.Scanner;

public class RobotDirectionsNSWE {
    
    
    public static void main(String[] args)
    {
        char[] arr = {'N','S','M','M','E','W','E','S','M','S','M'};
        position(arr,5,3);
    }
//    Grid(100*500)
//    Robot Position – (5,3)
//    Sequence — {N,S,M,M,E,W,E,S,M,S,M} North, East, West, South, Move forward
    public static void position(char[] arr, int row, int col) {

        int currPos = 0;

        for (int i = 1; i < arr.length; i++) {

            switch (arr[i]) {
            case 'N':
                currPos = 1;
                break;
            case 'S':
                currPos = 2;
                break;
            case 'W':
                currPos = 3;
                break;
            case 'E':
                currPos = 4;
                break;
            case 'M':
                switch (currPos) {
                case 1:
                    row--;
                    break;
                case 2:
                    row++;
                    break;
                case 3:
                    col--;
                    break;
                case 4:
                    col++;
                    break;
                }
                break;
            }
        }

        System.out.println("Current Position : [" + row + ", " + col + "]");
    }
}
