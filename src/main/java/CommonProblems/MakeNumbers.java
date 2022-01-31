package CommonProblems;
/*
* The following program increases/decreases the value of A and B until A is equal to X and B is equal to Y. Find the bug:
* */
public class MakeNumbers {
    public static void main(String[] args) {
        MakeTheNumbersMatch(10,15,30,30);
    }
    public static void MakeTheNumbersMatch(int a, int b, int x, int y)
    {
        //bug is having these two conditions together, if a or b one of them reaches its target then other will not get incremented
        // This can be refactored into two while loops one for each variable.
        while(a!=x && b!=y)
        {
            if(a> x)
            {
                a--;
            }
            else
            {
                a++;
            }
            if(b>y)
            {
                b--;
            }
            else
            {
                b++;
            }
        }
    }
}
