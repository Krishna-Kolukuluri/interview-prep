package arraysPrograms;

import java.io.*;

public class CrossandDotProductVector {
    static int n = 3;

    // Function that return
    // dot product of two vector array.
    static int dotProduct(int vect_A[], int vect_B[]) {

        int product = 0;

        // Loop for calculate cot product
        for (int i = 0; i < n; i++)
            product = product + vect_A[i] * vect_B[i];
        return product;
    }

    // Function to find
    // cross product of two vector array.
    static void crossProduct(int vect_A[], int vect_B[],
            int cross_P[])
    {

        cross_P[0] = vect_A[1] * vect_B[2]
                - vect_A[2] * vect_B[1];
        cross_P[1] = vect_A[2] * vect_B[0]
                - vect_A[0] * vect_B[2];
        cross_P[2] = vect_A[0] * vect_B[1]
                - vect_A[1] * vect_B[0];
    }

    // Driver code
    public static void main(String[] args) {
        int vect_A[] = { 3, -5, 4 };
        int vect_B[] = { 2, 6, 5 };
        int cross_P[] = new int[n];

        // dotProduct function call
        System.out.print("Dot product:");
        System.out.println(dotProduct(vect_A, vect_B));

        // crossProduct function call
        System.out.print("Cross product:");
        crossProduct(vect_A, vect_B, cross_P);

        // Loop that print
        // cross product of two vector array.
        for (int i = 0; i < n; i++)

            System.out.print(cross_P[i] + " ");
    }
}
