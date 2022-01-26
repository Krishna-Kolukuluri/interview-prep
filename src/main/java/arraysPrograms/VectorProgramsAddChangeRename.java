package arraysPrograms;

import java.util.Vector;

public class VectorProgramsAddChangeRename {

    public static void main(String args[]){
        changingElements();
    }
    
    static void addElements(){
        // create default vector
        Vector v1 = new Vector();
  
          // Add elements using add() method
        v1.add(1);
        v1.add(2);
        v1.add("geeks");
        v1.add("forGeeks");
        v1.add(3);
          
          // print the vector to the console
        System.out.println("Vector v1 is " + v1);
  
        // create generic vector
        Vector<Integer> v2 = new Vector<Integer>();
  
        v2.add(1);
        v2.add(2);
        v2.add(3);
        System.out.println("Vector v2 is " + v2);
    }
    
    static void changingElements(){
     // Creating an empty Vector 
        Vector<Integer> vec_tor = new Vector<Integer>(); 
  
        // Use add() method to add elements in the vector 
        vec_tor.add(12); 
        vec_tor.add(23); 
        vec_tor.add(22); 
        vec_tor.add(10); 
        vec_tor.add(20); 
  
        // Displaying the Vector 
        System.out.println("Vector: " + vec_tor); 
  
        // Using set() method to replace 12 with 21 
        System.out.println("The Object that is replaced is: "
                        + vec_tor.set(0, 21)); 
  
        // Using set() method to replace 20 with 50 
        System.out.println("The Object that is replaced is: "
                        + vec_tor.set(4, 50)); 
  
        // Displaying the modified vector 
        System.out.println("The new Vector is:" + vec_tor); 
    }
    
    static void RemovingElements(){
        // create default vector of capacity 10
        Vector v = new Vector();
  
          // Add elements using add() method
        v.add(1);
        v.add(2);
        v.add("Geeks");
        v.add("forGeeks");
        v.add(4);
  
        // removing first occurrence element at 1
        v.remove(1);
  
        // checking vector
        System.out.println("after removal: " + v);
    }
}
