package ds.dstype.arraytype;

import java.util.ArrayDeque;

public class arraydeque {
    public static void main(String[] args) {
        //Using ArrayDeque as stack
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("1st");
        stack.push("2nd");
        
        stack.pop(); //removes most recently added element i.e. 2nd
        stack.getFirst(); stack.pop(); //Both removes top element.

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("1st");
        queue.offer("2nd");

        queue.pollLast(); queue.getLast(); //both removes last element from the queue i.e. least recently added element.
    }
}
