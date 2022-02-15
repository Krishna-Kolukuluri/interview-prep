package concepts;

import java.nio.BufferOverflowException;

public class Exceptions {
    /*
    * A buffer overflow occurs when data is written beyond the boundaries of a fixed length buffer overwriting adjacent
    * memory locations which may include other buffers, variables and program flow data. Considered the “nuclear bomb”
    * of the software industry, the buffer overflow is one of the most persistent security vulnerabilities and frequently used attacks.
    * */
    public static void main(String[] args) {
        try{
            int importantData =1;
            int[]  buffer = new int[10];

            for (int i =0; i < 15; i++)
                buffer[i] = 7;

            System.out.println("after buffer overflow ");
            System.out.println("Important data  = "+importantData);

        }catch (BufferOverflowException bufferOverflowException){
            System.out.println(bufferOverflowException.getMessage());
        }
/*        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println(arrayIndexOutOfBoundsException.getMessage());
        }*/
        finally {
            System.out.println("In the code above, buffer has 10 elements but the loop attempts to writes through 15 elements, " +
                    "which can result in a buffer overflow in many languages. In Java, the code results in an ArrayIndexOutOfBoundsException:");
        }
    }
}
