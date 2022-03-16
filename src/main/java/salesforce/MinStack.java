package salesforce;

import java.util.*;

/*
* https://leetcode.com/problems/min-stack/solution/
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
* */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<int[]> minStack;

    public MinStack() {
        Stack<Integer> stack = new Stack<>();
        Stack<int[]> minStack = new Stack<>();
    }
    
    public void push(int x) {
        
        // We always put the number onto the main stack.
        stack.push(x);
        
        // If the min stack is empty, or this number is smaller than
        // the top of the min stack, put it on with a count of 1.
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[]{x, 1});
        }
        
        // Else if this number is equal to what's currently at the top
        // of the min stack, then increment the count at the top by 1.
        else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }

    public void pop() {
        
        // If the top of min stack is the same as the top of stack
        // then we need to decrement the count at the top by 1.
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }
        
        // If the count at the top of min stack is now 0, then remove
        // that value as we're done with it.
        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }
        
        // And like before, pop the top of the main stack.
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }
}
/*
* Complexity Analysis

Let nn be the total number of operations performed.

Time Complexity : O(1)O(1) for all operations.

push(...): Checking the top of a Stack, comparing numbers, and pushing to the top of a Stack (or adding to the end of an Array or List) are all O(1)O(1) operations. Therefore, this overall is an O(1)O(1) operation.

pop(...): Popping from a Stack (or removing from the end of an Array, or List) is an O(1)O(1) operation.

top(...): Looking at the top of a Stack is an O(1)O(1) operation.

getMin(...): Same as above. This operation is O(1)O(1) because we do not need to compare values to find it. If we had not kept track of it on the Stack, and instead had to search for it each time, the overall time complexity would have been O(n)O(n).

Space Complexity : O(n)O(n).

Worst case is that all the operations are push. In this case, there will be O(2 \cdot n) = O(n)O(2⋅n)=O(n) space used.
* */
