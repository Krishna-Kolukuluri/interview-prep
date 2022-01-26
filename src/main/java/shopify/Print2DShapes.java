package shopify;

public class Print2DShapes {
 // Java implementation of menu driven
 // programme to print solid 2D shapes
     // Function to print a circle
     static void circle(int radius)
     {
     
     for (int i = 0; i <= 2 * radius; i++)
         {
             for (int j = 0; j <= 2 * radius; j++)
             {
                 double distance =
                 Math.sqrt((double)(i - radius)
                         * (i - radius) + (j - radius)
                                         * (j - radius));
     
                 if (distance > radius - 0.5 &&
                         distance < radius + 0.5)
                 
                     System.out.print("*");
                 else
                     System.out.print(" ");
             }
             
             System.out.println();
         }
     }
     
     // Function to print a square or a rectangle
     static void rectangle(int l, int b)
     {
     
         int i, j;
         
         for (i = 1; i <= l; i++)
         {
             for (j = 1; j <= b; j++)
                 if (i == 1 || i == l || j == 1 || j == b)
                     System.out.print("*");
                 else
                     System.out.print(" ");
         
             System.out.println();
         }
     }
     
     // Function to print triangle
     static void triangle(int side)
     {
         int i, j;
         
         for (i = 1; i <= side; i++)
         {
             for (j = i; j < side; j++)
                 System.out.print(" ");
     
             for (j = 1; j <= (2 * i - 1); j++)
             {
                 if (i == side || j == 1 ||
                                 j == (2 * i - 1))
                     System.out.print("*");
                 else
                     System.out.print(" ");
             }
             System.out.println();
         }
     }
     
     // Function to print hexagon
     static void hexagon(int length)
     {
         int l, j, i, k;
         for (i = 1, k = length, l = 2 * length - 1;
                             i < length; i++, k--, l++)
         {
             for (j = 0; j < 3 * length; j++)
                 if (j >= k && j <= l)
                     System.out.print("*");
                 else
                     System.out.print(" ");
             System.out.println();
         }
         for (i = 0, k = 1, l = 3 * length - 2;
                 i < length; i++, k++, l--)
         {
             for (j = 0; j < 3 * length; j++)
                 if (j >= k && j <= l)
                     System.out.print("*");
                 else
                     System.out.print(" ");
             System.out.println();
         }
     }
     
     // Function takes user choice
     static void printPattern(int choice)
     {
     
         int radius, length, breadth, side;
         
         switch (choice)
         {
         
         // For Circle
         case 1:
             radius = 4;
             circle(radius);
             break;
     
         // For rectangle/square
         case 2:
             length = 3; breadth = 8;
             rectangle(length, breadth);
             break;
     
         // For triangle
         case 3:
             side = 6;
             triangle(side);
             break;
     
         // For hexagon
         case 4:
             side = 4;
             hexagon(side);
             break;
         default:
             System.out.print("Wrong choice\n");
         }
     }

 // Driver Program to test above function
 public static void main(String args[])
 {
     int choice = 3;
     printPattern(choice);
 }
 }

